export interface IMedico {
  id: number;
  rut?: string | null;
  nombre?: string | null;
  aPaterno?: string | null;
  aMaterno?: string | null;
  especialidad?: string | null;
}

export type NewMedico = Omit<IMedico, 'id'> & { id: null };
