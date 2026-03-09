-- ============================================================
-- SARI-SARI STORE SEED DATA
-- 50 Filipino everyday products with 5-10 variants each
-- ============================================================

-- ============================================================
-- CUSTOMERS (20)
-- ============================================================
INSERT INTO customers (name, phone, address, active, created_at, updated_at)
VALUES ('Maria Santos', '09171234567', 'Blk 1 Lot 2 Sampaguita St, Caloocan', true, NOW(), NOW()),
       ('Jose Reyes', '09182345678', '123 Rizal Ave, Manila', true, NOW(), NOW()),
       ('Ana Cruz', '09193456789', '456 Mabini St, Quezon City', true, NOW(), NOW()),
       ('Pedro Dela Cruz', '09204567890', '789 Bonifacio St, Makati', true, NOW(), NOW()),
       ('Rosa Garcia', '09215678901', 'Purok 3 Malaya, Pasig', true, NOW(), NOW()),
       ('Juan Mendoza', '09226789012', '321 Luna St, Marikina', true, NOW(), NOW()),
       ('Lita Flores', '09237890123', '654 Del Pilar St, Mandaluyong', true, NOW(), NOW()),
       ('Ramon Torres', '09248901234', '987 Aguinaldo St, San Juan', true, NOW(), NOW()),
       ('Nenita Villanueva', '09259012345', 'Blk 5 Lot 3 Jasmine St, Valenzuela', true, NOW(), NOW()),
       ('Carlos Bautista', '09260123456', '147 Quezon Blvd, Paranaque', true, NOW(), NOW()),
       ('Nena Ramos', '09271234568', '258 Taft Ave, Las Pinas', true, NOW(), NOW()),
       ('Mario Aquino', '09282345679', '369 Roxas Blvd, Muntinlupa', true, NOW(), NOW()),
       ('Tessie Navarro', '09293456780', 'Purok 1 Bagong Silang, Caloocan', true, NOW(), NOW()),
       ('Roberto Castillo', '09204567891', '741 Shaw Blvd, Pasig', true, NOW(), NOW()),
       ('Carina Morales', '09215678902', '852 EDSA, Quezon City', true, NOW(), NOW()),
       ('Danilo Soriano', '09226789013', '963 Commonwealth Ave, Quezon City', true, NOW(), NOW()),
       ('Imelda Pascual', '09237890124', 'Blk 2 Lot 7 Rose St, Novaliches', true, NOW(), NOW()),
       ('Ernesto Salazar', '09248901235', '159 Magsaysay Ave, Manila', true, NOW(), NOW()),
       ('Gloria Domingo', '09259012346', '357 Aurora Blvd, Cubao', true, NOW(), NOW()),
       ('Alfredo Villafuerte', '09260123457', '468 Katipunan Ave, QC', true, NOW(), NOW());

-- ============================================================
-- PRODUCTS (50)
-- ============================================================
INSERT INTO products (name, description, active, created_at, updated_at)
VALUES ('Coca-Cola', 'Popular softdrink', true, NOW(), NOW()),                     -- 1
       ('Lucky Me Noodles', 'Instant noodles', true, NOW(), NOW()),                -- 2
       ('Argentina Corned Beef', 'Canned corned beef', true, NOW(), NOW()),        -- 3
       ('Datu Puti Soy Sauce', 'Soy sauce condiment', true, NOW(), NOW()),         -- 4
       ('Datu Puti Vinegar', 'White cane vinegar', true, NOW(), NOW()),            -- 5
       ('Sprite', 'Lemon-lime softdrink', true, NOW(), NOW()),                     -- 6
       ('Royal Tru-Orange', 'Orange flavored softdrink', true, NOW(), NOW()),      -- 7
       ('Pepsi', 'Cola softdrink', true, NOW(), NOW()),                            -- 8
       ('Milo', 'Chocolate malt drink', true, NOW(), NOW()),                       -- 9
       ('Nescafe 3in1', 'Instant coffee mix', true, NOW(), NOW()),                 -- 10
       ('Bear Brand Milk', 'Sterilized filled milk', true, NOW(), NOW()),          -- 11
       ('Alaska Evaporated Milk', 'Evaporated filled milk', true, NOW(), NOW()),   -- 12
       ('Magnolia Ice Cream', 'Ice cream', true, NOW(), NOW()),                    -- 13
       ('Sky Flakes Crackers', 'Plain crackers', true, NOW(), NOW()),              -- 14
       ('Rebisco Crackers', 'Assorted crackers', true, NOW(), NOW()),              -- 15
       ('Loaded Chocolate Snack', 'Wafer snack with filling', true, NOW(), NOW()), -- 16
       ('Oishi Prawn Crackers', 'Prawn flavored snack', true, NOW(), NOW()),       -- 17
       ('Chippy Corn Chips', 'Corn chips snack', true, NOW(), NOW()),              -- 18
       ('Piattos Chips', 'Potato chips snack', true, NOW(), NOW()),                -- 19
       ('Nova Country Cheddar', 'Corn snack', true, NOW(), NOW()),                 -- 20
       ('Champion Detergent Bar', 'Laundry detergent bar', true, NOW(), NOW()),    -- 21
       ('Tide Detergent Powder', 'Laundry detergent powder', true, NOW(), NOW()),  -- 22
       ('Ariel Detergent Powder', 'Laundry detergent powder', true, NOW(), NOW()), -- 23
       ('Surf Detergent Powder', 'Laundry detergent powder', true, NOW(), NOW()),  -- 24
       ('Joy Dishwashing Liquid', 'Dishwashing liquid', true, NOW(), NOW()),       -- 25
       ('Palmolive Shampoo', 'Hair shampoo', true, NOW(), NOW()),                  -- 26
       ('Head and Shoulders', 'Anti-dandruff shampoo', true, NOW(), NOW()),        -- 27
       ('Pantene Shampoo', 'Hair shampoo', true, NOW(), NOW()),                    -- 28
       ('Safeguard Soap', 'Antibacterial soap', true, NOW(), NOW()),               -- 29
       ('Dove Soap', 'Beauty bar soap', true, NOW(), NOW()),                       -- 30
       ('Colgate Toothpaste', 'Toothpaste', true, NOW(), NOW()),                   -- 31
       ('Close Up Toothpaste', 'Toothpaste', true, NOW(), NOW()),                  -- 32
       ('San Miguel Beer', 'Beer', true, NOW(), NOW()),                            -- 33
       ('Red Horse Beer', 'Strong beer', true, NOW(), NOW()),                      -- 34
       ('Tanduay Rum', 'Rum', true, NOW(), NOW()),                                 -- 35
       ('Emperador Brandy', 'Brandy', true, NOW(), NOW()),                         -- 36
       ('Marlboro Cigarettes', 'Cigarettes', true, NOW(), NOW()),                  -- 37
       ('Philip Morris Cigarettes', 'Cigarettes', true, NOW(), NOW()),             -- 38
       ('Mighty Cigarettes', 'Cigarettes', true, NOW(), NOW()),                    -- 39
       ('555 Sardines', 'Canned sardines in tomato sauce', true, NOW(), NOW()),    -- 40
       ('Mega Sardines', 'Canned sardines', true, NOW(), NOW()),                   -- 41
       ('Century Tuna', 'Canned tuna', true, NOW(), NOW()),                        -- 42
       ('CDO Meatloaf', 'Canned meatloaf', true, NOW(), NOW()),                    -- 43
       ('Purefoods Corned Beef', 'Canned corned beef', true, NOW(), NOW()),        -- 44
       ('UFC Banana Ketchup', 'Banana ketchup', true, NOW(), NOW()),               -- 45
       ('Del Monte Tomato Sauce', 'Tomato sauce', true, NOW(), NOW()),             -- 46
       ('Knorr Seasoning', 'Liquid seasoning', true, NOW(), NOW()),                -- 47
       ('Magic Sarap', 'All-in-one seasoning granules', true, NOW(), NOW()),       -- 48
       ('Ajinomoto', 'Umami seasoning', true, NOW(), NOW()),                       -- 49
       ('White King Detergent', 'Detergent powder', true, NOW(), NOW());
-- 50

-- ============================================================
-- PRODUCT VARIANTS
-- ============================================================

-- 1. Coca-Cola
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (1, 'COKE-8OZ-BTL', 12.00, '8oz', NULL, 'Bottle', 0, true, 0, NOW(), NOW()),
       (1, 'COKE-1L-BTL', 35.00, '1L', NULL, 'Bottle', 0, true, 0, NOW(), NOW()),
       (1, 'COKE-1.5L-BTL', 55.00, '1.5L', NULL, 'Bottle', 0, true, 0, NOW(), NOW()),
       (1, 'COKE-330ML-CAN', 25.00, '330ml', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (1, 'COKE-250ML-CAN', 18.00, '250ml', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (1, 'COKE-2L-BTL', 75.00, '2L', NULL, 'Bottle', 0, true, 0, NOW(), NOW());

-- 2. Lucky Me Noodles
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (2, 'LM-CHKN-55G', 9.00, '55g', 'Chicken', 'Pack', 0, true, 0, NOW(), NOW()),
       (2, 'LM-BEEF-55G', 9.00, '55g', 'Beef', 'Pack', 0, true, 0, NOW(), NOW()),
       (2, 'LM-PORK-55G', 9.00, '55g', 'Pork', 'Pack', 0, true, 0, NOW(), NOW()),
       (2, 'LM-SPICY-55G', 9.00, '55g', 'Spicy', 'Pack', 0, true, 0, NOW(), NOW()),
       (2, 'LM-GUSTO-CHKN-70G', 12.00, '70g', 'Chicken', 'Pack', 0, true, 0, NOW(), NOW()),
       (2, 'LM-GUSTO-BEEF-70G', 12.00, '70g', 'Beef', 'Pack', 0, true, 0, NOW(), NOW()),
       (2, 'LM-CANTON-ORIG-65G', 11.00, '65g', 'Original', 'Pack', 0, true, 0, NOW(), NOW());

-- 3. Argentina Corned Beef
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (3, 'ARG-CB-85G-CAN', 22.00, '85g', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (3, 'ARG-CB-150G-CAN', 38.00, '150g', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (3, 'ARG-CB-175G-CAN', 45.00, '175g', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (3, 'ARG-CB-260G-CAN', 65.00, '260g', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (3, 'ARG-CB-380G-CAN', 89.00, '380g', NULL, 'Can', 0, true, 0, NOW(), NOW());

-- 4. Datu Puti Soy Sauce
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (4, 'DP-SOY-20ML-SACHET', 2.00, '20ml', NULL, 'Sachet', 0, true, 0, NOW(), NOW()),
       (4, 'DP-SOY-200ML-BTL', 18.00, '200ml', NULL, 'Bottle', 0, true, 0, NOW(), NOW()),
       (4, 'DP-SOY-350ML-BTL', 28.00, '350ml', NULL, 'Bottle', 0, true, 0, NOW(), NOW()),
       (4, 'DP-SOY-500ML-BTL', 38.00, '500ml', NULL, 'Bottle', 0, true, 0, NOW(), NOW()),
       (4, 'DP-SOY-1L-BTL', 65.00, '1L', NULL, 'Bottle', 0, true, 0, NOW(), NOW());

-- 5. Datu Puti Vinegar
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (5, 'DP-VIN-20ML-SACHET', 2.00, '20ml', NULL, 'Sachet', 0, true, 0, NOW(), NOW()),
       (5, 'DP-VIN-200ML-BTL', 15.00, '200ml', NULL, 'Bottle', 0, true, 0, NOW(), NOW()),
       (5, 'DP-VIN-350ML-BTL', 24.00, '350ml', NULL, 'Bottle', 0, true, 0, NOW(), NOW()),
       (5, 'DP-VIN-500ML-BTL', 32.00, '500ml', NULL, 'Bottle', 0, true, 0, NOW(), NOW()),
       (5, 'DP-VIN-1L-BTL', 55.00, '1L', NULL, 'Bottle', 0, true, 0, NOW(), NOW());

-- 6. Sprite
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (6, 'SPRITE-8OZ-BTL', 12.00, '8oz', NULL, 'Bottle', 0, true, 0, NOW(), NOW()),
       (6, 'SPRITE-1L-BTL', 35.00, '1L', NULL, 'Bottle', 0, true, 0, NOW(), NOW()),
       (6, 'SPRITE-1.5L-BTL', 55.00, '1.5L', NULL, 'Bottle', 0, true, 0, NOW(), NOW()),
       (6, 'SPRITE-330ML-CAN', 25.00, '330ml', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (6, 'SPRITE-2L-BTL', 75.00, '2L', NULL, 'Bottle', 0, true, 0, NOW(), NOW());

-- 7. Royal Tru-Orange
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (7, 'ROYAL-8OZ-BTL', 12.00, '8oz', 'Orange', 'Bottle', 0, true, 0, NOW(), NOW()),
       (7, 'ROYAL-1L-BTL', 35.00, '1L', 'Orange', 'Bottle', 0, true, 0, NOW(), NOW()),
       (7, 'ROYAL-1.5L-BTL', 55.00, '1.5L', 'Orange', 'Bottle', 0, true, 0, NOW(), NOW()),
       (7, 'ROYAL-330ML-CAN', 25.00, '330ml', 'Orange', 'Can', 0, true, 0, NOW(), NOW()),
       (7, 'ROYAL-2L-BTL', 72.00, '2L', 'Orange', 'Bottle', 0, true, 0, NOW(), NOW());

-- 8. Pepsi
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (8, 'PEPSI-8OZ-BTL', 12.00, '8oz', NULL, 'Bottle', 0, true, 0, NOW(), NOW()),
       (8, 'PEPSI-1L-BTL', 35.00, '1L', NULL, 'Bottle', 0, true, 0, NOW(), NOW()),
       (8, 'PEPSI-1.5L-BTL', 55.00, '1.5L', NULL, 'Bottle', 0, true, 0, NOW(), NOW()),
       (8, 'PEPSI-330ML-CAN', 25.00, '330ml', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (8, 'PEPSI-2L-BTL', 72.00, '2L', NULL, 'Bottle', 0, true, 0, NOW(), NOW());

-- 9. Milo
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (9, 'MILO-22G-SACHET', 8.00, '22g', NULL, 'Sachet', 0, true, 0, NOW(), NOW()),
       (9, 'MILO-200G-PACK', 85.00, '200g', NULL, 'Pack', 0, true, 0, NOW(), NOW()),
       (9, 'MILO-400G-TIN', 165.00, '400g', NULL, 'Tin', 0, true, 0, NOW(), NOW()),
       (9, 'MILO-1KG-TIN', 380.00, '1kg', NULL, 'Tin', 0, true, 0, NOW(), NOW()),
       (9, 'MILO-240ML-RTD', 22.00, '240ml', NULL, 'Bottle', 0, true, 0, NOW(), NOW());

-- 10. Nescafe 3in1
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (10, 'NESC-ORIG-20G', 7.00, '20g', 'Original', 'Sachet', 0, true, 0, NOW(), NOW()),
       (10, 'NESC-STRONG-20G', 7.00, '20g', 'Strong', 'Sachet', 0, true, 0, NOW(), NOW()),
       (10, 'NESC-DECAF-20G', 7.00, '20g', 'Decaf', 'Sachet', 0, true, 0, NOW(), NOW()),
       (10, 'NESC-ORIG-10S-BOX', 65.00, '10s', 'Original', 'Box', 0, true, 0, NOW(), NOW()),
       (10, 'NESC-STRONG-10S-BOX', 65.00, '10s', 'Strong', 'Box', 0, true, 0, NOW(), NOW());

-- 11. Bear Brand Milk
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (11, 'BB-MILK-33ML-SACHET', 8.00, '33ml', NULL, 'Sachet', 0, true, 0, NOW(), NOW()),
       (11, 'BB-MILK-155ML-CAN', 22.00, '155ml', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (11, 'BB-MILK-370ML-CAN', 48.00, '370ml', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (11, 'BB-MILK-300ML-BTL', 42.00, '300ml', NULL, 'Bottle', 0, true, 0, NOW(), NOW()),
       (11, 'BB-ADULT-33G-SACHET', 9.00, '33g', 'Adult', 'Sachet', 0, true, 0, NOW(), NOW());

-- 12. Alaska Evaporated Milk
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (12, 'AK-EVAP-155ML-CAN', 18.00, '155ml', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (12, 'AK-EVAP-370ML-CAN', 42.00, '370ml', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (12, 'AK-EVAP-410ML-CAN', 48.00, '410ml', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (12, 'AK-KREAM-155ML-CAN', 22.00, '155ml', 'Kream', 'Can', 0, true, 0, NOW(), NOW()),
       (12, 'AK-CHOCO-155ML-CAN', 22.00, '155ml', 'Chocolate', 'Can', 0, true, 0, NOW(), NOW());

-- 13. Magnolia Ice Cream
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (13, 'MAG-IC-CHOCO-SCOOP', 15.00, '1 scoop', 'Chocolate', 'Cup', 0, true, 0, NOW(), NOW()),
       (13, 'MAG-IC-VAN-SCOOP', 15.00, '1 scoop', 'Vanilla', 'Cup', 0, true, 0, NOW(), NOW()),
       (13, 'MAG-IC-STRAW-SCOOP', 15.00, '1 scoop', 'Strawberry', 'Cup', 0, true, 0, NOW(), NOW()),
       (13, 'MAG-IC-UBE-SCOOP', 15.00, '1 scoop', 'Ube', 'Cup', 0, true, 0, NOW(), NOW()),
       (13, 'MAG-IC-QUESO-SCOOP', 15.00, '1 scoop', 'Queso Real', 'Cup', 0, true, 0, NOW(), NOW());

-- 14. Sky Flakes Crackers
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (14, 'SF-PLAIN-33G', 10.00, '33g', 'Plain', 'Pack', 0, true, 0, NOW(), NOW()),
       (14, 'SF-PLAIN-250G', 55.00, '250g', 'Plain', 'Pack', 0, true, 0, NOW(), NOW()),
       (14, 'SF-CHKN-33G', 10.00, '33g', 'Chicken', 'Pack', 0, true, 0, NOW(), NOW()),
       (14, 'SF-ONION-33G', 10.00, '33g', 'Onion', 'Pack', 0, true, 0, NOW(), NOW()),
       (14, 'SF-PLAIN-10S-BOX', 95.00, '10s', 'Plain', 'Box', 0, true, 0, NOW(), NOW());

-- 15. Rebisco Crackers
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (15, 'REB-PLAIN-33G', 8.00, '33g', 'Plain', 'Pack', 0, true, 0, NOW(), NOW()),
       (15, 'REB-CHEESE-33G', 8.00, '33g', 'Cheese', 'Pack', 0, true, 0, NOW(), NOW()),
       (15, 'REB-CHOCO-33G', 8.00, '33g', 'Chocolate', 'Pack', 0, true, 0, NOW(), NOW()),
       (15, 'REB-PLAIN-250G', 48.00, '250g', 'Plain', 'Pack', 0, true, 0, NOW(), NOW()),
       (15, 'REB-ASSORTED-10S', 75.00, '10s', 'Assorted', 'Box', 0, true, 0, NOW(), NOW());

-- 16. Loaded Chocolate Snack
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (16, 'LOADED-UBE-30G', 15.00, '30g', 'Ube', 'Pack', 0, true, 0, NOW(), NOW()),
       (16, 'LOADED-CHOCO-30G', 15.00, '30g', 'Chocolate', 'Pack', 0, true, 0, NOW(), NOW()),
       (16, 'LOADED-CARAMEL-30G', 15.00, '30g', 'Caramel', 'Pack', 0, true, 0, NOW(), NOW()),
       (16, 'LOADED-UBE-60G', 28.00, '60g', 'Ube', 'Pack', 0, true, 0, NOW(), NOW()),
       (16, 'LOADED-CHOCO-60G', 28.00, '60g', 'Chocolate', 'Pack', 0, true, 0, NOW(), NOW()),
       (16, 'LOADED-CARAMEL-60G', 28.00, '60g', 'Caramel', 'Pack', 0, true, 0, NOW(), NOW());

-- 17. Oishi Prawn Crackers
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (17, 'OISHI-ORIG-60G', 15.00, '60g', 'Original', 'Pack', 0, true, 0, NOW(), NOW()),
       (17, 'OISHI-SPICY-60G', 15.00, '60g', 'Spicy', 'Pack', 0, true, 0, NOW(), NOW()),
       (17, 'OISHI-GARLIC-60G', 15.00, '60g', 'Garlic', 'Pack', 0, true, 0, NOW(), NOW()),
       (17, 'OISHI-ORIG-90G', 22.00, '90g', 'Original', 'Pack', 0, true, 0, NOW(), NOW()),
       (17, 'OISHI-SPICY-90G', 22.00, '90g', 'Spicy', 'Pack', 0, true, 0, NOW(), NOW());

-- 18. Chippy Corn Chips
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (18, 'CHIPPY-BBQ-110G', 22.00, '110g', 'BBQ', 'Pack', 0, true, 0, NOW(), NOW()),
       (18, 'CHIPPY-CHILI-110G', 22.00, '110g', 'Chili Cheese', 'Pack', 0, true, 0, NOW(), NOW()),
       (18, 'CHIPPY-BBQ-55G', 12.00, '55g', 'BBQ', 'Pack', 0, true, 0, NOW(), NOW()),
       (18, 'CHIPPY-CHILI-55G', 12.00, '55g', 'Chili Cheese', 'Pack', 0, true, 0, NOW(), NOW()),
       (18, 'CHIPPY-BBQ-22G', 6.00, '22g', 'BBQ', 'Pack', 0, true, 0, NOW(), NOW());

-- 19. Piattos Chips
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (19, 'PIATTOS-CHEESE-85G', 25.00, '85g', 'Cheese', 'Pack', 0, true, 0, NOW(), NOW()),
       (19, 'PIATTOS-SOUR-85G', 25.00, '85g', 'Sour Cream', 'Pack', 0, true, 0, NOW(), NOW()),
       (19, 'PIATTOS-PIZZA-85G', 25.00, '85g', 'Pizza', 'Pack', 0, true, 0, NOW(), NOW()),
       (19, 'PIATTOS-CHEESE-40G', 14.00, '40g', 'Cheese', 'Pack', 0, true, 0, NOW(), NOW()),
       (19, 'PIATTOS-SOUR-40G', 14.00, '40g', 'Sour Cream', 'Pack', 0, true, 0, NOW(), NOW());

-- 20. Nova Country Cheddar
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (20, 'NOVA-CHEDDAR-78G', 22.00, '78g', 'Country Cheddar', 'Pack', 0, true, 0, NOW(), NOW()),
       (20, 'NOVA-MULTIGRAIN-78G', 22.00, '78g', 'Multigrain', 'Pack', 0, true, 0, NOW(), NOW()),
       (20, 'NOVA-CHEDDAR-30G', 10.00, '30g', 'Country Cheddar', 'Pack', 0, true, 0, NOW(), NOW()),
       (20, 'NOVA-MULTIGRAIN-30G', 10.00, '30g', 'Multigrain', 'Pack', 0, true, 0, NOW(), NOW()),
       (20, 'NOVA-CHEDDAR-22G', 7.00, '22g', 'Country Cheddar', 'Pack', 0, true, 0, NOW(), NOW());

-- 21. Champion Detergent Bar
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (21, 'CHAMP-BAR-90G', 8.00, '90g', NULL, 'Bar', 0, true, 0, NOW(), NOW()),
       (21, 'CHAMP-BAR-180G', 14.00, '180g', NULL, 'Bar', 0, true, 0, NOW(), NOW()),
       (21, 'CHAMP-BAR-350G', 25.00, '350g', NULL, 'Bar', 0, true, 0, NOW(), NOW()),
       (21, 'CHAMP-COLOR-90G', 8.00, '90g', 'Color', 'Bar', 0, true, 0, NOW(), NOW()),
       (21, 'CHAMP-COLOR-180G', 14.00, '180g', 'Color', 'Bar', 0, true, 0, NOW(), NOW());

-- 22. Tide Detergent Powder
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (22, 'TIDE-ORIG-55G-SACHET', 9.00, '55g', 'Original', 'Sachet', 0, true, 0, NOW(), NOW()),
       (22, 'TIDE-ORIG-500G-PACK', 75.00, '500g', 'Original', 'Pack', 0, true, 0, NOW(), NOW()),
       (22, 'TIDE-ORIG-1KG-PACK', 138.00, '1kg', 'Original', 'Pack', 0, true, 0, NOW(), NOW()),
       (22, 'TIDE-COLOR-55G-SACHET', 9.00, '55g', 'Color', 'Sachet', 0, true, 0, NOW(), NOW()),
       (22, 'TIDE-PLUS-55G-SACHET', 10.00, '55g', 'Plus Downy', 'Sachet', 0, true, 0, NOW(), NOW());

-- 23. Ariel Detergent Powder
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (23, 'ARIEL-ORIG-55G-SACHET', 9.00, '55g', 'Original', 'Sachet', 0, true, 0, NOW(), NOW()),
       (23, 'ARIEL-ORIG-500G-PACK', 78.00, '500g', 'Original', 'Pack', 0, true, 0, NOW(), NOW()),
       (23, 'ARIEL-ORIG-1KG-PACK', 145.00, '1kg', 'Original', 'Pack', 0, true, 0, NOW(), NOW()),
       (23, 'ARIEL-COOL-55G-SACHET', 9.00, '55g', 'Cool', 'Sachet', 0, true, 0, NOW(), NOW()),
       (23, 'ARIEL-POD-3S', 45.00, '3s', 'Original', 'Pack', 0, true, 0, NOW(), NOW());

-- 24. Surf Detergent Powder
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (24, 'SURF-55G-SACHET', 8.00, '55g', 'Original', 'Sachet', 0, true, 0, NOW(), NOW()),
       (24, 'SURF-500G-PACK', 65.00, '500g', 'Original', 'Pack', 0, true, 0, NOW(), NOW()),
       (24, 'SURF-1KG-PACK', 118.00, '1kg', 'Original', 'Pack', 0, true, 0, NOW(), NOW()),
       (24, 'SURF-FLORAL-55G-SACHET', 8.00, '55g', 'Floral', 'Sachet', 0, true, 0, NOW(), NOW()),
       (24, 'SURF-BLUE-55G-SACHET', 8.00, '55g', 'Blue', 'Sachet', 0, true, 0, NOW(), NOW());

-- 25. Joy Dishwashing Liquid
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (25, 'JOY-LEMON-15ML-SACHET', 3.00, '15ml', 'Lemon', 'Sachet', 0, true, 0, NOW(), NOW()),
       (25, 'JOY-LEMON-200ML-BTL', 38.00, '200ml', 'Lemon', 'Bottle', 0, true, 0, NOW(), NOW()),
       (25, 'JOY-LEMON-500ML-BTL', 82.00, '500ml', 'Lemon', 'Bottle', 0, true, 0, NOW(), NOW()),
       (25, 'JOY-ORANGE-200ML-BTL', 38.00, '200ml', 'Orange', 'Bottle', 0, true, 0, NOW(), NOW()),
       (25, 'JOY-ANTIBAC-200ML-BTL', 42.00, '200ml', 'Antibacterial', 'Bottle', 0, true, 0, NOW(), NOW());

-- 26. Palmolive Shampoo
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (26, 'PALM-SMOOTH-12ML-SACHET', 6.00, '12ml', 'Smooth', 'Sachet', 0, true, 0, NOW(), NOW()),
       (26, 'PALM-SHINE-12ML-SACHET', 6.00, '12ml', 'Shine', 'Sachet', 0, true, 0, NOW(), NOW()),
       (26, 'PALM-SMOOTH-180ML-BTL', 85.00, '180ml', 'Smooth', 'Bottle', 0, true, 0, NOW(), NOW()),
       (26, 'PALM-SHINE-180ML-BTL', 85.00, '180ml', 'Shine', 'Bottle', 0, true, 0, NOW(), NOW()),
       (26, 'PALM-NATURALS-12ML-SACHET', 6.00, '12ml', 'Naturals', 'Sachet', 0, true, 0, NOW(), NOW());

-- 27. Head and Shoulders
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (27, 'HNS-COOL-12ML-SACHET', 8.00, '12ml', 'Cool Menthol', 'Sachet', 0, true, 0, NOW(), NOW()),
       (27, 'HNS-SMOOTH-12ML-SACHET', 8.00, '12ml', 'Smooth Silk', 'Sachet', 0, true, 0, NOW(), NOW()),
       (27, 'HNS-COOL-180ML-BTL', 155.00, '180ml', 'Cool Menthol', 'Bottle', 0, true, 0, NOW(), NOW()),
       (27, 'HNS-SMOOTH-180ML-BTL', 155.00, '180ml', 'Smooth Silk', 'Bottle', 0, true, 0, NOW(), NOW()),
       (27, 'HNS-ITCHY-12ML-SACHET', 8.00, '12ml', 'Itchy Scalp', 'Sachet', 0, true, 0, NOW(), NOW());

-- 28. Pantene Shampoo
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (28, 'PANT-SMOOTH-12ML-SACHET', 7.00, '12ml', 'Smooth', 'Sachet', 0, true, 0, NOW(), NOW()),
       (28, 'PANT-VOLUME-12ML-SACHET', 7.00, '12ml', 'Volume', 'Sachet', 0, true, 0, NOW(), NOW()),
       (28, 'PANT-SMOOTH-180ML-BTL', 135.00, '180ml', 'Smooth', 'Bottle', 0, true, 0, NOW(), NOW()),
       (28, 'PANT-VOLUME-180ML-BTL', 135.00, '180ml', 'Volume', 'Bottle', 0, true, 0, NOW(), NOW()),
       (28, 'PANT-HAIRFALL-12ML-SACHET', 7.00, '12ml', 'Hairfall Control', 'Sachet', 0, true, 0, NOW(), NOW());

-- 29. Safeguard Soap
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (29, 'SG-WHITE-55G', 18.00, '55g', 'White', 'Bar', 0, true, 0, NOW(), NOW()),
       (29, 'SG-WHITE-90G', 28.00, '90g', 'White', 'Bar', 0, true, 0, NOW(), NOW()),
       (29, 'SG-BLUE-90G', 28.00, '90g', 'Blue', 'Bar', 0, true, 0, NOW(), NOW()),
       (29, 'SG-PINK-90G', 28.00, '90g', 'Pink', 'Bar', 0, true, 0, NOW(), NOW()),
       (29, 'SG-PURE-90G', 30.00, '90g', 'Pure White', 'Bar', 0, true, 0, NOW(), NOW());

-- 30. Dove Soap
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (30, 'DOVE-ORIG-90G', 42.00, '90g', 'Original', 'Bar', 0, true, 0, NOW(), NOW()),
       (30, 'DOVE-PINK-90G', 42.00, '90g', 'Pink', 'Bar', 0, true, 0, NOW(), NOW()),
       (30, 'DOVE-SHEA-90G', 42.00, '90g', 'Shea Butter', 'Bar', 0, true, 0, NOW(), NOW()),
       (30, 'DOVE-ORIG-135G', 58.00, '135g', 'Original', 'Bar', 0, true, 0, NOW(), NOW()),
       (30, 'DOVE-MEN-90G', 42.00, '90g', 'Men Care', 'Bar', 0, true, 0, NOW(), NOW());

-- 31. Colgate Toothpaste
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (31, 'COLG-FRESH-25ML-SACHET', 8.00, '25ml', 'Fresh Cool Mint', 'Sachet', 0, true, 0, NOW(), NOW()),
       (31, 'COLG-FRESH-50ML', 22.00, '50ml', 'Fresh Cool Mint', 'Tube', 0, true, 0, NOW(), NOW()),
       (31, 'COLG-FRESH-100ML', 42.00, '100ml', 'Fresh Cool Mint', 'Tube', 0, true, 0, NOW(), NOW()),
       (31, 'COLG-OPTIC-50ML', 28.00, '50ml', 'Optic White', 'Tube', 0, true, 0, NOW(), NOW()),
       (31, 'COLG-SENSITIVE-50ML', 32.00, '50ml', 'Sensitive', 'Tube', 0, true, 0, NOW(), NOW());

-- 32. Close Up Toothpaste
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (32, 'CU-RED-25ML-SACHET', 7.00, '25ml', 'Red Hot', 'Sachet', 0, true, 0, NOW(), NOW()),
       (32, 'CU-COOL-25ML-SACHET', 7.00, '25ml', 'Cool Mint', 'Sachet', 0, true, 0, NOW(), NOW()),
       (32, 'CU-RED-50ML', 18.00, '50ml', 'Red Hot', 'Tube', 0, true, 0, NOW(), NOW()),
       (32, 'CU-COOL-50ML', 18.00, '50ml', 'Cool Mint', 'Tube', 0, true, 0, NOW(), NOW()),
       (32, 'CU-RED-100ML', 35.00, '100ml', 'Red Hot', 'Tube', 0, true, 0, NOW(), NOW());

-- 33. San Miguel Beer
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (33, 'SMB-PALE-330ML-CAN', 45.00, '330ml', 'Pale Pilsen', 'Can', 0, true, 0, NOW(), NOW()),
       (33, 'SMB-PALE-320ML-BTL', 42.00, '320ml', 'Pale Pilsen', 'Bottle', 0, true, 0, NOW(), NOW()),
       (33, 'SMB-LIGHT-330ML-CAN', 48.00, '330ml', 'Light', 'Can', 0, true, 0, NOW(), NOW()),
       (33, 'SMB-APPLE-330ML-CAN', 52.00, '330ml', 'Apple', 'Can', 0, true, 0, NOW(), NOW()),
       (33, 'SMB-CERVEZA-320ML-BTL', 45.00, '320ml', 'Cerveza Negra', 'Bottle', 0, true, 0, NOW(), NOW());

-- 34. Red Horse Beer
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (34, 'RH-ORIG-330ML-CAN', 52.00, '330ml', 'Original', 'Can', 0, true, 0, NOW(), NOW()),
       (34, 'RH-ORIG-500ML-BTL', 65.00, '500ml', 'Original', 'Bottle', 0, true, 0, NOW(), NOW()),
       (34, 'RH-ORIG-1L-BTL', 118.00, '1L', 'Original', 'Bottle', 0, true, 0, NOW(), NOW()),
       (34, 'RH-BERRY-330ML-CAN', 55.00, '330ml', 'Berry Blast', 'Can', 0, true, 0, NOW(), NOW()),
       (34, 'RH-MANGO-330ML-CAN', 55.00, '330ml', 'Mango', 'Can', 0, true, 0, NOW(), NOW());

-- 35. Tanduay Rum
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (35, 'TDY-5YR-375ML-BTL', 165.00, '375ml', '5 Years', 'Bottle', 0, true, 0, NOW(), NOW()),
       (35, 'TDY-5YR-750ML-BTL', 295.00, '750ml', '5 Years', 'Bottle', 0, true, 0, NOW(), NOW()),
       (35, 'TDY-LIGHT-375ML-BTL', 145.00, '375ml', 'Light', 'Bottle', 0, true, 0, NOW(), NOW()),
       (35, 'TDY-ICE-330ML-CAN', 52.00, '330ml', 'Ice', 'Can', 0, true, 0, NOW(), NOW()),
       (35, 'TDY-RHUM-100ML-BTL', 55.00, '100ml', 'Original', 'Bottle', 0, true, 0, NOW(), NOW());

-- 36. Emperador Brandy
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (36, 'EMP-LIGHT-375ML-BTL', 135.00, '375ml', 'Light', 'Bottle', 0, true, 0, NOW(), NOW()),
       (36, 'EMP-LIGHT-750ML-BTL', 245.00, '750ml', 'Light', 'Bottle', 0, true, 0, NOW(), NOW()),
       (36, 'EMP-ORIG-375ML-BTL', 155.00, '375ml', 'Original', 'Bottle', 0, true, 0, NOW(), NOW()),
       (36, 'EMP-ORIG-750ML-BTL', 275.00, '750ml', 'Original', 'Bottle', 0, true, 0, NOW(), NOW()),
       (36, 'EMP-DOUBLE-375ML-BTL', 185.00, '375ml', 'Double', 'Bottle', 0, true, 0, NOW(), NOW());

-- 37. Marlboro Cigarettes
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (37, 'MARL-RED-1S', 6.00, '1s', 'Red', 'Stick', 0, true, 0, NOW(), NOW()),
       (37, 'MARL-RED-10S', 58.00, '10s', 'Red', 'Pack', 0, true, 0, NOW(), NOW()),
       (37, 'MARL-BLUE-1S', 6.00, '1s', 'Blue', 'Stick', 0, true, 0, NOW(), NOW()),
       (37, 'MARL-BLUE-10S', 58.00, '10s', 'Blue', 'Pack', 0, true, 0, NOW(), NOW()),
       (37, 'MARL-MENTHOL-1S', 6.00, '1s', 'Menthol', 'Stick', 0, true, 0, NOW(), NOW()),
       (37, 'MARL-MENTHOL-10S', 58.00, '10s', 'Menthol', 'Pack', 0, true, 0, NOW(), NOW());

-- 38. Philip Morris Cigarettes
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (38, 'PM-ORIG-1S', 5.00, '1s', 'Original', 'Stick', 0, true, 0, NOW(), NOW()),
       (38, 'PM-ORIG-10S', 48.00, '10s', 'Original', 'Pack', 0, true, 0, NOW(), NOW()),
       (38, 'PM-MENTHOL-1S', 5.00, '1s', 'Menthol', 'Stick', 0, true, 0, NOW(), NOW()),
       (38, 'PM-MENTHOL-10S', 48.00, '10s', 'Menthol', 'Pack', 0, true, 0, NOW(), NOW()),
       (38, 'PM-BLUE-10S', 48.00, '10s', 'Blue', 'Pack', 0, true, 0, NOW(), NOW());

-- 39. Mighty Cigarettes
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (39, 'MIGHTY-RED-1S', 3.00, '1s', 'Red', 'Stick', 0, true, 0, NOW(), NOW()),
       (39, 'MIGHTY-RED-10S', 28.00, '10s', 'Red', 'Pack', 0, true, 0, NOW(), NOW()),
       (39, 'MIGHTY-MENTHOL-1S', 3.00, '1s', 'Menthol', 'Stick', 0, true, 0, NOW(), NOW()),
       (39, 'MIGHTY-MENTHOL-10S', 28.00, '10s', 'Menthol', 'Pack', 0, true, 0, NOW(), NOW()),
       (39, 'MIGHTY-BLUE-10S', 28.00, '10s', 'Blue', 'Pack', 0, true, 0, NOW(), NOW());

-- 40. 555 Sardines
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (40, '555-TOM-155G-CAN', 22.00, '155g', 'Tomato Sauce', 'Can', 0, true, 0, NOW(), NOW()),
       (40, '555-SPICY-155G-CAN', 22.00, '155g', 'Spicy', 'Can', 0, true, 0, NOW(), NOW()),
       (40, '555-LEMON-155G-CAN', 22.00, '155g', 'Lemon', 'Can', 0, true, 0, NOW(), NOW()),
       (40, '555-TOM-255G-CAN', 35.00, '255g', 'Tomato Sauce', 'Can', 0, true, 0, NOW(), NOW()),
       (40, '555-SPICY-255G-CAN', 35.00, '255g', 'Spicy', 'Can', 0, true, 0, NOW(), NOW());

-- 41. Mega Sardines
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (41, 'MEGA-TOM-155G-CAN', 20.00, '155g', 'Tomato Sauce', 'Can', 0, true, 0, NOW(), NOW()),
       (41, 'MEGA-SPICY-155G-CAN', 20.00, '155g', 'Spicy', 'Can', 0, true, 0, NOW(), NOW()),
       (41, 'MEGA-LEMON-155G-CAN', 20.00, '155g', 'Lemon', 'Can', 0, true, 0, NOW(), NOW()),
       (41, 'MEGA-GUISADO-155G-CAN', 20.00, '155g', 'Guisado', 'Can', 0, true, 0, NOW(), NOW()),
       (41, 'MEGA-TOM-220G-CAN', 32.00, '220g', 'Tomato Sauce', 'Can', 0, true, 0, NOW(), NOW());

-- 42. Century Tuna
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (42, 'CT-CHUNKS-155G-CAN', 28.00, '155g', 'Chunks in Oil', 'Can', 0, true, 0, NOW(), NOW()),
       (42, 'CT-HOT-155G-CAN', 28.00, '155g', 'Hot and Spicy', 'Can', 0, true, 0, NOW(), NOW()),
       (42, 'CT-CALDERETA-155G-CAN', 28.00, '155g', 'Caldereta', 'Can', 0, true, 0, NOW(), NOW()),
       (42, 'CT-CHUNKS-180G-POUCH', 32.00, '180g', 'Chunks in Oil', 'Pouch', 0, true, 0, NOW(), NOW()),
       (42, 'CT-HOT-180G-POUCH', 32.00, '180g', 'Hot and Spicy', 'Pouch', 0, true, 0, NOW(), NOW());

-- 43. CDO Meatloaf
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (43, 'CDO-ML-150G-CAN', 38.00, '150g', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (43, 'CDO-ML-230G-CAN', 55.00, '230g', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (43, 'CDO-ML-350G-CAN', 78.00, '350g', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (43, 'CDO-SPICY-150G-CAN', 40.00, '150g', 'Spicy', 'Can', 0, true, 0, NOW(), NOW()),
       (43, 'CDO-CHEESE-150G-CAN', 40.00, '150g', 'Cheese', 'Can', 0, true, 0, NOW(), NOW());

-- 44. Purefoods Corned Beef
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (44, 'PF-CB-85G-CAN', 22.00, '85g', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (44, 'PF-CB-150G-CAN', 38.00, '150g', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (44, 'PF-CB-200G-CAN', 48.00, '200g', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (44, 'PF-CB-260G-CAN', 62.00, '260g', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (44, 'PF-SPICY-150G-CAN', 40.00, '150g', 'Spicy', 'Can', 0, true, 0, NOW(), NOW());

-- 45. UFC Banana Ketchup
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (45, 'UFC-KETCH-20ML-SACHET', 2.00, '20ml', 'Original', 'Sachet', 0, true, 0, NOW(), NOW()),
       (45, 'UFC-KETCH-200G-BTL', 28.00, '200g', 'Original', 'Bottle', 0, true, 0, NOW(), NOW()),
       (45, 'UFC-KETCH-320G-BTL', 42.00, '320g', 'Original', 'Bottle', 0, true, 0, NOW(), NOW()),
       (45, 'UFC-SPICY-200G-BTL', 28.00, '200g', 'Spicy', 'Bottle', 0, true, 0, NOW(), NOW()),
       (45, 'UFC-KETCH-550G-BTL', 65.00, '550g', 'Original', 'Bottle', 0, true, 0, NOW(), NOW());

-- 46. Del Monte Tomato Sauce
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (46, 'DM-TOM-115G-CAN', 18.00, '115g', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (46, 'DM-TOM-250G-CAN', 35.00, '250g', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (46, 'DM-TOM-500G-CAN', 62.00, '500g', NULL, 'Can', 0, true, 0, NOW(), NOW()),
       (46, 'DM-TOM-20ML-SACHET', 5.00, '20ml', NULL, 'Sachet', 0, true, 0, NOW(), NOW()),
       (46, 'DM-SPAG-250G-CAN', 38.00, '250g', 'Spaghetti', 'Can', 0, true, 0, NOW(), NOW());

-- 47. Knorr Seasoning
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (47, 'KNORR-LIQ-7ML-SACHET', 3.00, '7ml', 'Original', 'Sachet', 0, true, 0, NOW(), NOW()),
       (47, 'KNORR-LIQ-100ML-BTL', 38.00, '100ml', 'Original', 'Bottle', 0, true, 0, NOW(), NOW()),
       (47, 'KNORR-LIQ-250ML-BTL', 78.00, '250ml', 'Original', 'Bottle', 0, true, 0, NOW(), NOW()),
       (47, 'KNORR-CUBE-10G', 5.00, '10g', 'Chicken', 'Cube', 0, true, 0, NOW(), NOW()),
       (47, 'KNORR-CUBE-BEEF-10G', 5.00, '10g', 'Beef', 'Cube', 0, true, 0, NOW(), NOW());

-- 48. Magic Sarap
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (48, 'MS-8G-SACHET', 3.00, '8g', NULL, 'Sachet', 0, true, 0, NOW(), NOW()),
       (48, 'MS-18G-SACHET', 6.00, '18g', NULL, 'Sachet', 0, true, 0, NOW(), NOW()),
       (48, 'MS-100G-PACK', 28.00, '100g', NULL, 'Pack', 0, true, 0, NOW(), NOW()),
       (48, 'MS-250G-PACK', 58.00, '250g', NULL, 'Pack', 0, true, 0, NOW(), NOW()),
       (48, 'MS-500G-PACK', 105.00, '500g', NULL, 'Pack', 0, true, 0, NOW(), NOW());

-- 49. Ajinomoto
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (49, 'AJI-7G-SACHET', 3.00, '7g', NULL, 'Sachet', 0, true, 0, NOW(), NOW()),
       (49, 'AJI-18G-SACHET', 6.00, '18g', NULL, 'Sachet', 0, true, 0, NOW(), NOW()),
       (49, 'AJI-100G-PACK', 25.00, '100g', NULL, 'Pack', 0, true, 0, NOW(), NOW()),
       (49, 'AJI-250G-PACK', 52.00, '250g', NULL, 'Pack', 0, true, 0, NOW(), NOW()),
       (49, 'AJI-500G-PACK', 98.00, '500g', NULL, 'Pack', 0, true, 0, NOW(), NOW());

-- 50. White King Detergent
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (50, 'WK-55G-SACHET', 8.00, '55g', 'Original', 'Sachet', 0, true, 0, NOW(), NOW()),
       (50, 'WK-500G-PACK', 65.00, '500g', 'Original', 'Pack', 0, true, 0, NOW(), NOW()),
       (50, 'WK-1KG-PACK', 118.00, '1kg', 'Original', 'Pack', 0, true, 0, NOW(), NOW()),
       (50, 'WK-COLOR-55G-SACHET', 8.00, '55g', 'Color', 'Sachet', 0, true, 0, NOW(), NOW()),
       (50, 'WK-POWER-55G-SACHET', 9.00, '55g', 'Power White', 'Sachet', 0, true, 0, NOW(), NOW());
