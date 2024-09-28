-- Insert Role 'CLIENT' with a valid UUID
INSERT INTO role (id, name) VALUES ('d290f1ee-6c54-4b01-90e6-d701748f0851', 'CLIENT')
ON CONFLICT (name) DO NOTHING;

-- Insert Authorities with valid UUIDs
INSERT INTO authority (id, name) VALUES ('9a4d57b6-1b2d-4e48-9a61-97a037a46f9c', 'CAN_PLACE_ORDER')
ON CONFLICT (name) DO NOTHING;
INSERT INTO authority (id, name) VALUES ('9b7169f8-133f-4c5c-8362-38be0361f662', 'CAN_RETRIEVE_PURCHASE_HISTORY')
ON CONFLICT (name) DO NOTHING;
INSERT INTO authority (id, name) VALUES ('17f95b57-1cf4-4976-9308-5c110d8ec7f3', 'CAN_RETRIEVE_PRODUCTS')
ON CONFLICT (name) DO NOTHING;

-- Link Authorities to Role 'CLIENT'
INSERT INTO role_authority (role_id, authority_id) VALUES ('d290f1ee-6c54-4b01-90e6-d701748f0851', '9a4d57b6-1b2d-4e48-9a61-97a037a46f9c');
INSERT INTO role_authority (role_id, authority_id) VALUES ('d290f1ee-6c54-4b01-90e6-d701748f0851', '9b7169f8-133f-4c5c-8362-38be0361f662');
INSERT INTO role_authority (role_id, authority_id) VALUES ('d290f1ee-6c54-4b01-90e6-d701748f0851', '17f95b57-1cf4-4976-9308-5c110d8ec7f3');

-- Insert Tea Sorts
INSERT INTO tea_type (id, name, min_Age) VALUES ('d5f54d93-0fd5-4e43-962f-3945a54c1b95', 'White', 0);
INSERT INTO tea_type (id, name, min_Age) VALUES ('a8e4c127-080e-4b93-b0f4-cc0c9f167f42', 'Green', 0);
INSERT INTO tea_type (id, name, min_Age) VALUES ('fbf85e74-6e12-4f7c-8444-66a22be9e2fb', 'Medical Herbs', 18);

-- Insert Teas for 'White' Tea Sort
INSERT INTO tea (id, name, buy_price, sell_price, tea_type_id, harvest_date)
VALUES ('a9d5e2cb-b4d7-48f3-b94f-e3c487789527', 'Master', 8, 16, 'd5f54d93-0fd5-4e43-962f-3945a54c1b95', '2023-09-15');

INSERT INTO tea (id, name, buy_price, sell_price, tea_type_id, harvest_date)
VALUES ('f94613b9-8af3-4722-bc6c-1b78e3d4b5d3', 'Student', 4, 12, 'd5f54d93-0fd5-4e43-962f-3945a54c1b95', '2023-07-12');

-- Insert Teas for 'Green' Tea Sort
INSERT INTO tea (id, name, buy_price, sell_price, tea_type_id, harvest_date)
VALUES ('295b516f-22d1-4f88-a5c3-50e918b27f35', 'Beginner', 4, 8, 'a8e4c127-080e-4b93-b0f4-cc0c9f167f42', '2023-08-22');

INSERT INTO tea (id, name, buy_price, sell_price, tea_type_id, harvest_date)
VALUES ('a0b59748-8e7b-4eb8-9be2-8e97e5a4ac4e', 'Pro', 6, 10, 'a8e4c127-080e-4b93-b0f4-cc0c9f167f42', '2023-08-05');

-- Insert Teas for 'Medical Herbs' Tea Sort
INSERT INTO tea (id, name, buy_price, sell_price, tea_type_id, harvest_date)
VALUES ('c4b8cfa6-57ae-4d75-b686-b7fc0b1ef890', 'Starter', 4, 8, 'fbf85e74-6e12-4f7c-8444-66a22be9e2fb', '2023-06-25');

INSERT INTO tea (id, name, buy_price, sell_price, tea_type_id, harvest_date)
VALUES ('f2467ec9-1c41-4d8b-b168-734d2f34580b', 'Experienced', 6, 10, 'fbf85e74-6e12-4f7c-8444-66a22be9e2fb', '2023-05-30');

-- Insert Rank 'Silver'
INSERT INTO rank (id, title, seeds_needed, reduction)
VALUES ('c0e7c75e-3e6b-4cfa-8a8b-f0b7fbe0b705', 'Silver', 20, 4);

-- Insert Rank 'Gold'
INSERT INTO rank (id, title, seeds_needed, reduction)
VALUES ('e1f3eab2-25fa-4521-86cb-faf3c92a12c9', 'Gold', 60, 7);

-- Insert Rank 'Platinum'
INSERT INTO rank (id, title, seeds_needed, reduction)
VALUES ('f4b987df-935a-4a8d-94b4-2bc9fc2c5d23', 'Platinum', 140, 9);

-- Insert Countries
INSERT INTO country (id, country_name, abbreviation) VALUES ('7b9f0a2b-ea5c-469d-a6c7-d1b4e5bba1c7', 'United States', 'US');
INSERT INTO country (id, country_name, abbreviation) VALUES ('3c056fa4-14e1-4e36-8994-f7e3c1c053cf', 'Canada', 'CA');
INSERT INTO country (id, country_name, abbreviation) VALUES ('d17e3e4f-37d1-49c3-a5a6-2b77464092de', 'United Kingdom', 'UK');
INSERT INTO country (id, country_name, abbreviation) VALUES ('ac4ed704-cc22-4c4c-9a56-34c0f53b5e0c', 'Germany', 'DE');
INSERT INTO country (id, country_name, abbreviation) VALUES ('593c6b17-5935-4f5a-84f2-1f4ab36b4748', 'France', 'FR');
INSERT INTO country (id, country_name, abbreviation) VALUES ('9270b21e-cd1b-41b2-8b0f-cc8b4d4f75e2', 'Italy', 'IT');
INSERT INTO country (id, country_name, abbreviation) VALUES ('f9c2c3f1-8ff1-4871-a47f-5f49db6f68d6', 'Spain', 'ES');
INSERT INTO country (id, country_name, abbreviation) VALUES ('f9f1dbb4-e5b6-4de7-8e75-08028a0f136d', 'Australia', 'AU');
INSERT INTO country (id, country_name, abbreviation) VALUES ('1f00b799-92d9-4e89-b95c-d49f37dc67e5', 'New Zealand', 'NZ');
INSERT INTO country (id, country_name, abbreviation) VALUES ('cf049c38-f834-478e-b13d-79198b77fa9c', 'Japan', 'JP');
INSERT INTO country (id, country_name, abbreviation) VALUES ('fe24a96b-f87f-4b24-bf10-4c535a3c7be9', 'China', 'CN');
INSERT INTO country (id, country_name, abbreviation) VALUES ('bfb7b91f-ff5c-4dbd-b90c-f0b7b16c43cb', 'India', 'IN');
INSERT INTO country (id, country_name, abbreviation) VALUES ('083d77d3-f479-42d1-ae13-107d54a6350e', 'Brazil', 'BR');
INSERT INTO country (id, country_name, abbreviation) VALUES ('f51c0262-c9de-4621-bd96-f012afc5b515', 'Mexico', 'MX');
INSERT INTO country (id, country_name, abbreviation) VALUES ('a37b2bdb-90d1-4b6c-85b6-1b5f08db9333', 'Russia', 'RU');
INSERT INTO country (id, country_name, abbreviation) VALUES ('929b5db6-702b-405d-8916-882b451cce21', 'South Africa', 'ZA');
INSERT INTO country (id, country_name, abbreviation) VALUES ('4e145d8d-f53e-4f93-94ae-7282484a1274', 'Argentina', 'AR');
INSERT INTO country (id, country_name, abbreviation) VALUES ('8a68e9d7-658a-4a9f-87f3-1364924cfec2', 'Chile', 'CL');
INSERT INTO country (id, country_name, abbreviation) VALUES ('6f857f8a-61f5-4e8a-bd79-c2d00e0c07a6', 'South Korea', 'KR');
INSERT INTO country (id, country_name, abbreviation) VALUES ('1141fc12-bb70-420e-8cf4-009b9f5a8346', 'Saudi Arabia', 'SA');

