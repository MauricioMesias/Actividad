import { Injectable } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

import dayjs from 'dayjs/esm';
import { DATE_TIME_FORMAT } from 'app/config/input.constants';
import { IReserva, NewReserva } from '../reserva.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts IReserva for edit and NewReservaFormGroupInput for create.
 */
type ReservaFormGroupInput = IReserva | PartialWithRequiredKeyOf<NewReserva>;

/**
 * Type that converts some properties for forms.
 */
type FormValueOf<T extends IReserva | NewReserva> = Omit<T, 'fechaHora'> & {
  fechaHora?: string | null;
};

type ReservaFormRawValue = FormValueOf<IReserva>;

type NewReservaFormRawValue = FormValueOf<NewReserva>;

type ReservaFormDefaults = Pick<NewReserva, 'id' | 'fechaHora'>;

type ReservaFormGroupContent = {
  id: FormControl<ReservaFormRawValue['id'] | NewReserva['id']>;
  fechaHora: FormControl<ReservaFormRawValue['fechaHora']>;
  motivo: FormControl<ReservaFormRawValue['motivo']>;
  paciente: FormControl<ReservaFormRawValue['paciente']>;
  medico: FormControl<ReservaFormRawValue['medico']>;
  centroSalud: FormControl<ReservaFormRawValue['centroSalud']>;
};

export type ReservaFormGroup = FormGroup<ReservaFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class ReservaFormService {
  createReservaFormGroup(reserva: ReservaFormGroupInput = { id: null }): ReservaFormGroup {
    const reservaRawValue = this.convertReservaToReservaRawValue({
      ...this.getFormDefaults(),
      ...reserva,
    });
    return new FormGroup<ReservaFormGroupContent>({
      id: new FormControl(
        { value: reservaRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        },
      ),
      fechaHora: new FormControl(reservaRawValue.fechaHora, {
        validators: [Validators.required],
      }),
      motivo: new FormControl(reservaRawValue.motivo),
      paciente: new FormControl(reservaRawValue.paciente),
      medico: new FormControl(reservaRawValue.medico),
      centroSalud: new FormControl(reservaRawValue.centroSalud),
    });
  }

  getReserva(form: ReservaFormGroup): IReserva | NewReserva {
    return this.convertReservaRawValueToReserva(form.getRawValue() as ReservaFormRawValue | NewReservaFormRawValue);
  }

  resetForm(form: ReservaFormGroup, reserva: ReservaFormGroupInput): void {
    const reservaRawValue = this.convertReservaToReservaRawValue({ ...this.getFormDefaults(), ...reserva });
    form.reset(
      {
        ...reservaRawValue,
        id: { value: reservaRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */,
    );
  }

  private getFormDefaults(): ReservaFormDefaults {
    const currentTime = dayjs();

    return {
      id: null,
      fechaHora: currentTime,
    };
  }

  private convertReservaRawValueToReserva(rawReserva: ReservaFormRawValue | NewReservaFormRawValue): IReserva | NewReserva {
    return {
      ...rawReserva,
      fechaHora: dayjs(rawReserva.fechaHora, DATE_TIME_FORMAT),
    };
  }

  private convertReservaToReservaRawValue(
    reserva: IReserva | (Partial<NewReserva> & ReservaFormDefaults),
  ): ReservaFormRawValue | PartialWithRequiredKeyOf<NewReservaFormRawValue> {
    return {
      ...reserva,
      fechaHora: reserva.fechaHora ? reserva.fechaHora.format(DATE_TIME_FORMAT) : undefined,
    };
  }
}
