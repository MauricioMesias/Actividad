import { IUser } from './user.model';

export const sampleWithRequiredData: IUser = {
  id: 3746,
  login: 'i',
};

export const sampleWithPartialData: IUser = {
  id: 20873,
  login: 'c',
};

export const sampleWithFullData: IUser = {
  id: 10342,
  login: 'y4d.7B',
};
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
