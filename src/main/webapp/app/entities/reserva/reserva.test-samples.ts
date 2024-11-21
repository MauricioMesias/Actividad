import dayjs from 'dayjs/esm';

import { IReserva, NewReserva } from './reserva.model';

export const sampleWithRequiredData: IReserva = {
  id: 239,
  fechaHora: dayjs('2024-11-20T20:30'),
};

export const sampleWithPartialData: IReserva = {
  id: 31070,
  fechaHora: dayjs('2024-11-20T23:46'),
};

export const sampleWithFullData: IReserva = {
  id: 28982,
  fechaHora: dayjs('2024-11-20T23:21'),
  motivo: 'when tempting',
};

export const sampleWithNewData: NewReserva = {
  fechaHora: dayjs('2024-11-20T19:37'),
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
