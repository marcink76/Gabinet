INSERT INTO gabinet.employee (last_name, name, password, role, salary, username, work_start, work_status, enabled)
VALUES ('Kowalska', 'Mariola', 'marr', 'USER_ROLE', '100', 'markow', '2012-11-10', 'RECEPTIONIST', TRUE);
INSERT INTO gabinet.employee (last_name, name, password, role, salary, username, work_start, work_status, enabled)
VALUES ('Justyna', 'Borkowska', 'm', 'USER_ROLE', '100', 'm', '2012-11-10', 'RECEPTIONIST', TRUE);
INSERT INTO gabinet.employee (last_name, name, password, role, salary, username, work_start, work_status, enabled)
VALUES ('Marzena', 'Wiśniewska', 'm', 'USER_ROLE', '100', 'w', '2012-11-10', 'RECEPTIONIST', TRUE);


INSERT INTO gabinet.treatment (Czas_trwania, name, price) VALUES ('0:15', 'masaz', '130');
INSERT INTO gabinet.treatment (Czas_trwania, name, price) VALUES ('0:15', 'podagra', '150');
INSERT INTO gabinet.treatment (Czas_trwania, name, price) VALUES ('0:15', 'henna', '30');
INSERT INTO gabinet.treatment (Czas_trwania, name, price) VALUES ('0:15', 'masaz', '150');


INSERT INTO gabinet.customer (email, nazwisko, imie, password, phone_number, registration_time, enabled) VALUES
  ('abk@o2.pl', 'Abkowski', 'Alex', 'mmm', '666666666', '2017-12-19 12:11:21', TRUE);
INSERT INTO gabinet.customer (email, nazwisko, imie, password, phone_number, registration_time, enabled) VALUES
  ('cbk@wp.pl', 'Ckowski', 'Tom', 'tt', '333333333', '2017-12-19 12:11:21', TRUE);
INSERT INTO gabinet.customer (email, nazwisko, imie, password, phone_number, registration_time, enabled) VALUES
  ('coni@o2.pl', 'Bkowska', 'Barbara', 'tt', '8888888888', '2017-12-19 12:11:21', TRUE);
