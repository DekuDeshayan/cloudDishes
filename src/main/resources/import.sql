INSERT INTO users VALUES (1,'2022-06-11 09:22:18.000000','superadmin@clouddishes.com','Super','M','$2a$10$WJYI7h30E3TLfmaQzcJECewr0vw06jBj8Ne7kv93tf3u0u98FYhtm','ADMIN','Admin','Admin'),(2,'2022-06-11 10:01:35.000000','abdl@gmail.com','Abdula','M','$2a$10$zUNOWA/068ET0efl3GGZZu0l2j5ImoWXWiovhXZAVzmRBadqyVKk2','MANAGER','Abdul','abdl'),(3,'2022-06-11 11:27:18.000000','mh4life@nanotechmoz.com','Ralph','M','$2a$10$zGEadPMCymVIoi1cLE2TyeySWBTn3jg7EjR9wUtUTjkERiPUWsIqu','MANAGER','Buraimo','mh4life'),(4,'2022-06-11 11:40:25.000000','maquina@nanotechmoz.com','Madruga','M','$2a$10$ZxgSKZ64W8gg201d1hvJNOascjz9Gr5GI74u.NKUjrdDl6slQprlu','MANAGER','Maquina','mMaquina'),(5,'2022-06-11 11:43:45.000000','bony@nanotechmoz.com','Bonifacio','M','$2a$10$1Jbdou/OJwA1fBscEnzfRe8A3lrlFAYgRH/THZT3AyNGBkuhZVyOi','MANAGER','felisberto','felisbertoSambo'),(6,'2022-06-11 23:06:46.000000','hilario@clouddishes.co.mz','Hilario','M','$2a$10$QSQhuLZ5mceRHqewKfYHVOw1uthATzXLQOKnkzFmmK2rQ2jXsP9Ry','CLIENT','Langa','Hilario'),(7,'2022-06-11 23:08:53.000000','sergiomaquina@nanotechmoz.com','Sergio','M','$2a$10$BCdpbAkR.BwmeuR1t1/J/evDB3YxqJi06u1rJyBmGvLEMdw1WTQeW','CLIENT','Maquina','SMaquina'),(8,'2022-06-11 23:14:24.000000','anyaforger@clouddishes.co.mz','Anya','F','$2a$10$jUWnl9WjIs94HSvPo5S.jOd9j0/OacrWcBKS9Bl2znFDovYDsg9W2','RECEPTIONIST','Forger','Anya');

INSERT INTO restaurant VALUES (4,12,'2022-06-11 13:03:02.000000',14,'kfc@nanotech.co.mz','KFC Restaurant',24,10,'842706809',5,3,'index.png','http://localhost:8080/api/restaurant/files/index11062022130302.png'),(5,9,'2022-06-11 17:02:54.000000',18,'dhowmz@nanotech.co.mz','Dhow Mozambique',1,9,'843222333',5,5,'50055846197_ebbbc18de4_b.jpg','http://localhost:8080/api/restaurant/files/50055846197_ebbbc18de4_b11062022170254.jpg'),(6,9,'2022-06-11 17:24:23.000000',13,'restaurantecostadosol@nanotech.co.mz','Restaurante Costa do Sol',38,7,'822282772',5,4,'index2.png','http://localhost:8080/api/restaurant/files/index211062022172423.png');

INSERT INTO request VALUES (1,'Order_Bacalhau a portuguesa','PENDING','2022-06-14 01:09:07.000000'),(2,'Order_Pizza 100g','PENDING','2022-06-14 01:58:57.000000'),(3,'Order_Pizza 100g','PENDING','2022-06-14 04:11:53.000000'),(4,'Order_Bacalhau a portuguesa','PENDING','2022-06-14 04:15:09.000000');

INSERT INTO orders VALUES (1,1,'Bacalhau a portuguesa','2022-06-14 01:09:07.000000',1,6,450),(2,2,'Pizza 100g','2022-06-14 01:58:57.000000',2,6,1450),(3,3,'Pizza 100g','2022-06-14 04:11:53.000000',3,6,1000),(4,4,'Bacalhau a portuguesa','2022-06-14 04:15:09.000000',4,6,450);

INSERT INTO order_delivery_address VALUES (1,'13','2','home','4','rua 23, avenida das industrias, casa 234'),(2,'13','39','Work','5','rua a, ibavete nr 32, avenida vladimir lenine n 124'),(3,'14','1','Work','5','quarteirao 13, paragem chapa, liberdade'),(4,'14','13','Zimpeto','5','Driven, estadio nacional, mole zimpeto');

INSERT INTO meal VALUES (1,'2022-06-11 15:54:01.000000','Bacalhau a portuguesa','FASTFOOD','Bacalhau',45,450,4,'bacalhau_a_portuguesa_117_orig.jpg','http://localhost:8080/api/meal/files/bacalhau_a_portuguesa_117_orig11062022155401.jpg'),(2,'2022-06-13 16:17:57.000000','Pizza 100g','FASTFOOD','Pizza',35,1000,4,'index.jpg','http://localhost:8080/api/meal/files/index13062022161757.jpg');
