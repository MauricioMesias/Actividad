import { ICentroSalud, NewCentroSalud } from './centro-salud.model';

export const sampleWithRequiredData: ICentroSalud = {
  id: 4961,
  nombre: 'who wasabi pushy',
  tipocentro: 'loosely oof soliloquy',
  direccion: 'volleyball recent whose',
};

export const sampleWithPartialData: ICentroSalud = {
  id: 27196,
  nombre: 'pointed',
  tipocentro: 'immediately catalyze',
  direccion: 'knife pretty',
};

export const sampleWithFullData: ICentroSalud = {
  id: 7988,
  nombre: 'about till rear',
  tipocentro: 'consequently',
  direccion: 'pastel accredit',
};

export const sampleWithNewData: NewCentroSalud = {
  nombre: 'musty concerning swanling',
  tipocentro: 'innovation and',
  direccion: 'for humidity really',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
