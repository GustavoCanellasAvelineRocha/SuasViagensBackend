CREATE TABLE travel (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    destination VARCHAR(255),
    duration INT,
    transport VARCHAR(255),
    type_of_travel VARCHAR(255),
    preco DOUBLE,
    travel_status VARCHAR(255),
    data_viagem DATE,
    FOREIGN KEY (id_usuario) REFERENCES user(id)
);