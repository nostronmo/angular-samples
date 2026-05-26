import { HttpClient, HttpParams } from '@angular/common/http';
import { MusicData } from '../model/chart.models';
import { Observable } from 'rxjs/internal/Observable';
import { inject, Injectable } from '@angular/core';
import { environment } from '../../../environment/environment.prod';

@Injectable({
  providedIn: 'root',
})
export class MusicService {
  private readonly apiUrl = `${environment.apiUrl}/v1/music`;
  private http = inject(HttpClient);

  getAllGenres(): Observable<MusicData[]> {
    return this.http.get<MusicData[]>(`${this.apiUrl}/genres`);
  }

  getMusicStatsByGenre(request: string): Observable<MusicData[]> {
    const params = new HttpParams().set('genre', request.toString());
    return this.http.get<MusicData[]>(`${this.apiUrl}/stats`, { params });
  }

  getMusicStatsBetweenGenres(request: string[]): Observable<MusicData[]> {
    let params = new HttpParams();
    request.forEach((genre) => {
      params = params.append('genre', genre);
    });
    return this.http.get<MusicData[]>(`${this.apiUrl}/compare`, { params });
  }
}
