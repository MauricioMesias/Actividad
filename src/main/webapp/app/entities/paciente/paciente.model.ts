import dayjs from 'dayjs/esm';

export interface IPaciente {
  id: number;
  rut?: string | null;
  nombre?: string | null;
  aPaterno?: string | null;
  aMaterno?: string | null;
  fechaNacimiento?: dayjs.Dayjs | null;
}

export type NewPaciente = Omit<IPaciente, 'id'> & { id: null };
