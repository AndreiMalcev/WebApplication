DROP TABLE IF EXISTS EXPLORER;

CREATE TABLE EXPLORER (
  PRIMARY KEY (id),
  id BIGINT auto_increment,
  parent varchar(255) NOT NULL,
  text varchar(255) NOT NULL,
  children BOOLEAN NOT NULL,
  UNIQUE (parent, text)
);

insert into  EXPLORER(parent, text, children) VALUES ('#' , 'root1', TRUE),
                                                     ('#' , 'root2', TRUE),
                                                     ('1' , 'node1', TRUE),
                                                     ('1' , 'node2', TRUE),
                                                     ('2' , 'node1', TRUE),
                                                     ('2' , 'node2', TRUE);
