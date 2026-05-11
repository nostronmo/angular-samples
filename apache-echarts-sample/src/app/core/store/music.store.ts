import { inject } from '@angular/core';
import { patchState, signalStore, withMethods, withState } from '@ngrx/signals';
import { rxMethod } from '@ngrx/signals/rxjs-interop';
import { pipe, switchMap, filter, tap } from 'rxjs';
import { tapResponse } from '@ngrx/operators';
import { MusicService } from '../service/music.service';
import { MusicData } from '../model/chart.models';

interface MusicState {
  tracks: MusicData[];
  isLoading: boolean;
  error: string | null;
}

const initialState: MusicState = {
  tracks: [],
  isLoading: false,
  error: null,
};

export const MusicStore = signalStore(
  withState(initialState),
  withMethods((store, musicService = inject(MusicService)) => ({
    loadAll: rxMethod<void>(
      pipe(
        filter(() => store.tracks().length === 0),
        tap(() => patchState(store, { isLoading: true })),
        switchMap(() =>
          musicService.getMusicData().pipe(
            tapResponse({
              next: (tracks) => patchState(store, { tracks, isLoading: false }),
              error: (err: any) =>
                patchState(store, {
                  error: err.message,
                  isLoading: false,
                }),
            }),
          ),
        ),
      ),
    ),
    findMusicByGenre: rxMethod<string>(
      pipe(
        tap(() => patchState(store, { isLoading: true })),
        switchMap((genre) =>
          musicService.getMusicDataByTrackGenre(genre).pipe(
            tapResponse({
              next: (tracks) => patchState(store, { tracks, isLoading: false }),
              error: (err: any) =>
                patchState(store, {
                  error: err.message,
                  isLoading: false,
                }),
            }),
          ),
        ),
      ),
    ),

    findMusicByPopularity: rxMethod<number>(
      pipe(
        tap(() => patchState(store, { isLoading: true })),
        switchMap((popularity) =>
          musicService.getMusicDataByPopularity(popularity).pipe(
            tapResponse({
              next: (tracks) => patchState(store, { tracks, isLoading: false }),
              error: (err: any) =>
                patchState(store, {
                  error: err.message,
                  isLoading: false,
                }),
            }),
          ),
        ),
      ),
    ),

    findMusicByDuration: rxMethod<number>(
      pipe(
        tap(() => patchState(store, { isLoading: true })),
        switchMap((duration) =>
          musicService.getMusicDataByDuration(duration).pipe(
            tapResponse({
              next: (tracks) => patchState(store, { tracks, isLoading: false }),
              error: (err: any) =>
                patchState(store, {
                  error: err.message,
                  isLoading: false,
                }),
            }),
          ),
        ),
      ),
    ),
  })),
);
