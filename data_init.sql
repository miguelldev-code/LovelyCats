-- Insertar Productos
INSERT INTO product (id, name_product, description, price, user_name, image) VALUES 
(nextval('hibernate_sequence'), 'Comida Premium Gatos', 'Alimento de alta calidad para gatos adultos, 3kg', '35.99', 'miguelldev', 'https://m.media-amazon.com/images/I/81xQ8j1s+JL._AC_SX679_.jpg'),
(nextval('hibernate_sequence'), 'Rascador Árbol', 'Rascador multinivel con hamaca y juguetes', '89.50', 'miguelldev', 'https://m.media-amazon.com/images/I/71Y-yAC7jPL._AC_SX679_.jpg'),
(nextval('hibernate_sequence'), 'Cama Cueva', 'Cama suave tipo cueva para mayor privacidad', '45.00', 'miguelldev', 'https://m.media-amazon.com/images/I/71w+7T0+qLL._AC_SX679_.jpg');

-- Insertar Mascotas para Adopción
INSERT INTO pet (id, name_pet, age, gender, description, status, adoption_date, user_name, image) VALUES
(nextval('hibernate_sequence'), 'Luna', 2, 'Hembra', 'Gatita muy cariñosa y tranquila, ideal para apartamentos.', 'Disponible', NOW(), 'miguelldev', 'https://images.unsplash.com/photo-1514888286974-6c03e2ca1dba?ixlib=rb-1.2.1&auto=format&fit=crop&w=1327&q=80'),
(nextval('hibernate_sequence'), 'Simba', 1, 'Macho', 'Juguetón y lleno de energía. Le encantan los niños.', 'Disponible', NOW(), 'miguelldev', 'https://images.unsplash.com/photo-1573865526739-10659fec78a5?ixlib=rb-1.2.1&auto=format&fit=crop&w=675&q=80'),
(nextval('hibernate_sequence'), 'Oliver', 3, 'Macho', 'Rescatado, necesita un hogar tranquilo y paciencia.', 'Disponible', NOW(), 'miguelldev', 'https://images.unsplash.com/photo-1495360019602-e001b22163d1?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80');
