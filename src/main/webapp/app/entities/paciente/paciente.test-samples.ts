import dayjs from 'dayjs/esm';

import { IPaciente, NewPaciente } from './paciente.model';

export const sampleWithRequiredData: IPaciente = {
  id: 23909,
  rut: 'uh-huh',
  nombre: 'ethical meanwhile alongside',
  aPaterno: 'till',
};

export const sampleWithPartialData: IPaciente = {
  id: 32545,
  rut: 'soulful',
  nombre: 'ick hmph whose',
  aPaterno: 'object gray',
  aMaterno: 'knottily',
  fechaNacimiento: dayjs('2024-11-21'),
};

export const sampleWithFullData: IPaciente = {
  id: 29216,
  rut: 'spook',
  nombre: 'daintily furiously leading',
  aPaterno: 'positively contractor',
  aMaterno: 'pish',
  fechaNacimiento: dayjs('2024-11-21'),
};

export const sampleWithNewData: NewPaciente = {
  rut: 'meh',
  nombre: 'hot cautious loftily',
  aPaterno: 'swift illustrious',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
