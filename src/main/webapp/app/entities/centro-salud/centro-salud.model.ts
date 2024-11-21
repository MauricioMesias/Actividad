export interface ICentroSalud {
  id: number;
  nombre?: string | null;
  tipocentro?: string | null;
  direccion?: string | null;
}

export type NewCentroSalud = Omit<ICentroSalud, 'id'> & { id: null };
