import {User} from "./user";

export interface Task {
  id: number;
  key: string;
  title: string;
  description: string;
  priority: Priority;
  status: Status;
  type: TicketType;
  assignee: User;
  reporter: User;
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
