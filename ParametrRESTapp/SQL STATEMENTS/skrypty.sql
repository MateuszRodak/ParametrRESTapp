CREATE TABLE Parametr(
                         ID long  PRIMARY KEY,
                         name varchar2(50) NOT NULL UNIQUE,
                         description varchar2(800)
);


CREATE TABLE Wartosc_parametru(
                                  ID long  PRIMARY KEY,
                                  data_od DATETIME,
                                  data_do DATETIME,
                                  wartosc_liczbowa Numeric,
                                  jednostka varchar2(2) check (jednostka in ('m3', 'kg', 'Mg')),
                                  wartosc_opisowa varchar2(30),
                                  parametr_id long,
                                  foreign key (parametr_id) references Parametr(ID)
)