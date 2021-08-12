import {User} from "./user";
import {Component} from "./component";
import {Label} from "./label";

export interface Ticket {
  id: string;
  key: string;
  title: string;
  description: string;
  priority: Priority;
  status: Status;
  type: TicketType;
  assignee: User;
  reporter: User;
  components: Component[];
  labels: Label[];
  watchers: User[];
}

export enum Priority {
  BLOCKER,
  CRITICAL,
  MAJOR,
  NORMAL,
  MINOR
}

export enum Status {
  OPEN,
  IN_PROGRESS,
  ON_HOLD,
  IMPLEMENTED,
  CLOSED
}

export enum TicketType {
  STORY,
  DEFECT,
  ACTION_ITEM
}
