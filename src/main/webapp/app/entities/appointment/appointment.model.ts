import { BaseEntity, User } from './../../shared';

export class Appointment implements BaseEntity {
    constructor(
        public id?: number,
        public dateTime?: any,
        public label?: string,
        public isRecurring?: boolean,
        public notes?: any,
        public customer?: BaseEntity,
        public activityBooked?: BaseEntity,
        public location?: BaseEntity,
        public provider?: User,
    ) {
        this.isRecurring = false;
    }
}
