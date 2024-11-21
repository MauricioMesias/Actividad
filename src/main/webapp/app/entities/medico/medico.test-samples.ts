import { IMedico, NewMedico } from './medico.model';

export const sampleWithRequiredData: IMedico = {
  id: 13896,
  rut: 'stylish',
  nombre: 'awareness ew standard',
  aPaterno: 'yet',
};

export const sampleWithPartialData: IMedico = {
  id: 19715,
  rut: 'while past towards',
  nombre: 'swath',
  aPaterno: 'apud focused majestically',
  aMaterno: 'indeed phew',
  especialidad: 'onto',
};

export const sampleWithFullData: IMedico = {
  id: 21892,
  rut: 'before',
  nombre: 'that massage brood',
  aPaterno: 'near',
  aMaterno: 'rarely apropos',
  especialidad: 'likewise venture',
};

export const sampleWithNewData: NewMedico = {
  rut: 'stunt',
  nombre: 'woot honestly carnival',
  aPaterno: 'fedora up',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
