import { IAuthority, NewAuthority } from './authority.model';

export const sampleWithRequiredData: IAuthority = {
  name: '74d7f4cb-4d42-4c81-969a-3fbdbf4a84d3',
};

export const sampleWithPartialData: IAuthority = {
  name: 'ff6ff0ee-0e7a-4098-903d-ab8e1c50de0f',
};

export const sampleWithFullData: IAuthority = {
  name: 'cf8ca636-e8d5-48e1-b6dd-452b045e70e8',
};

export const sampleWithNewData: NewAuthority = {
  name: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
