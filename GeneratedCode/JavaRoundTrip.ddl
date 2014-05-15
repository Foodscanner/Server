CREATE TABLE Article (_id  SERIAL NOT NULL, Flag_id int8 NOT NULL, Ingredient_id int8 NOT NULL, _name varchar(255), _description varchar(255), _imageURI varchar(255), _ingredients int4 NOT NULL, _flags int4 NOT NULL, _unnamed_ArticleUtil_ int4 NOT NULL, PRIMARY KEY (_id));
CREATE TABLE Flag (_id  BIGSERIAL NOT NULL, Ingredient_id int8 NOT NULL, Article_id int4 NOT NULL, _name varchar(255), _description varchar(255), _limitToProduct bool NOT NULL, PRIMARY KEY (_id));
CREATE TABLE Ingredient (_id  BIGSERIAL NOT NULL, _name varchar(255), _flags int4 NOT NULL, PRIMARY KEY (_id));
ALTER TABLE Article ADD CONSTRAINT FKArticle328968 FOREIGN KEY (Ingredient_id) REFERENCES Ingredient (_id);
ALTER TABLE Article ADD CONSTRAINT FKArticle5350 FOREIGN KEY (Flag_id) REFERENCES Flag (_id);
ALTER TABLE Flag ADD CONSTRAINT FKFlag988977 FOREIGN KEY (Article_id) REFERENCES Article (_id);
ALTER TABLE Flag ADD CONSTRAINT FKFlag755107 FOREIGN KEY (Ingredient_id) REFERENCES Ingredient (_id);
