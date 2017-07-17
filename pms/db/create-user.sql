CREATE USER 'productdb'@'localhost' IDENTIFIED BY 'productdb';

GRANT CREATE,DELETE,INSERT,SELECT,UPDATE ON productdb.* TO 'productdb'@'localhost';