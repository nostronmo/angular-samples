import { HttpClient, HttpParams } from '@angular/common/http';
import { MusicData } from '../model/chart.models';
import { Observable } from 'rxjs/internal/Observable';
import { inject, Injectable } from '@angular/core';
import { environment } from '../../../environment/environment.prod';

@Injectable({
  providedIn: 'root',
})
export class MusicService {
  private readonly apiUrl = `${environment.apiUrl}`;
  private http = inject(HttpClient);



  getMusicData(): Observable<MusicData[]> {
    return this.http.get<MusicData[]>(this.apiUrl);
  }

  getMusicDataByTrackGenre(request: string): Observable<MusicData[]> {
    const params = new HttpParams().set('track_genre', request.toString());
    return this.http.get<MusicData[]>(this.apiUrl, { params });
  }

  getMusicDataByPopularity(popularity: number = 0): Observable<MusicData[]> {
    const params = new HttpParams().set('popularity', popularity.toString());
    return this.http.get<MusicData[]>(this.apiUrl, { params });
  }

  getMusicDataByDuration(duration: number = 0): Observable<MusicData[]> {
    const params = new HttpParams().set('duration', duration.toString());
    return this.http.get<MusicData[]>(this.apiUrl, { params });
  }
}
