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
VALUES (1, 'COKE-8OZ-BTL', 12.00, '8oz', NULL, 'Bottle', 50, true, 0, NOW(), NOW()),
       (1, 'COKE-1L-BTL', 35.00, '1L', NULL, 'Bottle', 50, true, 0, NOW(), NOW()),
       (1, 'COKE-1.5L-BTL', 55.00, '1.5L', NULL, 'Bottle', 50, true, 0, NOW(), NOW()),
       (1, 'COKE-330ML-CAN', 25.00, '330ml', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (1, 'COKE-250ML-CAN', 18.00, '250ml', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (1, 'COKE-2L-BTL', 75.00, '2L', NULL, 'Bottle', 50, true, 0, NOW(), NOW());

-- 2. Lucky Me Noodles
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (2, 'LM-CHKN-55G', 9.00, '55g', 'Chicken', 'Pack', 50, true, 0, NOW(), NOW()),
       (2, 'LM-BEEF-55G', 9.00, '55g', 'Beef', 'Pack', 50, true, 0, NOW(), NOW()),
       (2, 'LM-PORK-55G', 9.00, '55g', 'Pork', 'Pack', 50, true, 0, NOW(), NOW()),
       (2, 'LM-SPICY-55G', 9.00, '55g', 'Spicy', 'Pack', 50, true, 0, NOW(), NOW()),
       (2, 'LM-GUSTO-CHKN-70G', 12.00, '70g', 'Chicken', 'Pack', 50, true, 0, NOW(), NOW()),
       (2, 'LM-GUSTO-BEEF-70G', 12.00, '70g', 'Beef', 'Pack', 50, true, 0, NOW(), NOW()),
       (2, 'LM-CANTON-ORIG-65G', 11.00, '65g', 'Original', 'Pack', 50, true, 0, NOW(), NOW());

-- 3. Argentina Corned Beef
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (3, 'ARG-CB-85G-CAN', 22.00, '85g', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (3, 'ARG-CB-150G-CAN', 38.00, '150g', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (3, 'ARG-CB-175G-CAN', 45.00, '175g', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (3, 'ARG-CB-260G-CAN', 65.00, '260g', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (3, 'ARG-CB-380G-CAN', 89.00, '380g', NULL, 'Can', 50, true, 0, NOW(), NOW());

-- 4. Datu Puti Soy Sauce
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (4, 'DP-SOY-20ML-SACHET', 2.00, '20ml', NULL, 'Sachet', 50, true, 0, NOW(), NOW()),
       (4, 'DP-SOY-200ML-BTL', 18.00, '200ml', NULL, 'Bottle', 50, true, 0, NOW(), NOW()),
       (4, 'DP-SOY-350ML-BTL', 28.00, '350ml', NULL, 'Bottle', 50, true, 0, NOW(), NOW()),
       (4, 'DP-SOY-500ML-BTL', 38.00, '500ml', NULL, 'Bottle', 50, true, 0, NOW(), NOW()),
       (4, 'DP-SOY-1L-BTL', 65.00, '1L', NULL, 'Bottle', 50, true, 0, NOW(), NOW());

-- 5. Datu Puti Vinegar
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (5, 'DP-VIN-20ML-SACHET', 2.00, '20ml', NULL, 'Sachet', 50, true, 0, NOW(), NOW()),
       (5, 'DP-VIN-200ML-BTL', 15.00, '200ml', NULL, 'Bottle', 50, true, 0, NOW(), NOW()),
       (5, 'DP-VIN-350ML-BTL', 24.00, '350ml', NULL, 'Bottle', 50, true, 0, NOW(), NOW()),
       (5, 'DP-VIN-500ML-BTL', 32.00, '500ml', NULL, 'Bottle', 50, true, 0, NOW(), NOW()),
       (5, 'DP-VIN-1L-BTL', 55.00, '1L', NULL, 'Bottle', 50, true, 0, NOW(), NOW());

-- 6. Sprite
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (6, 'SPRITE-8OZ-BTL', 12.00, '8oz', NULL, 'Bottle', 50, true, 0, NOW(), NOW()),
       (6, 'SPRITE-1L-BTL', 35.00, '1L', NULL, 'Bottle', 50, true, 0, NOW(), NOW()),
       (6, 'SPRITE-1.5L-BTL', 55.00, '1.5L', NULL, 'Bottle', 50, true, 0, NOW(), NOW()),
       (6, 'SPRITE-330ML-CAN', 25.00, '330ml', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (6, 'SPRITE-2L-BTL', 75.00, '2L', NULL, 'Bottle', 50, true, 0, NOW(), NOW());

-- 7. Royal Tru-Orange
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (7, 'ROYAL-8OZ-BTL', 12.00, '8oz', 'Orange', 'Bottle', 50, true, 0, NOW(), NOW()),
       (7, 'ROYAL-1L-BTL', 35.00, '1L', 'Orange', 'Bottle', 50, true, 0, NOW(), NOW()),
       (7, 'ROYAL-1.5L-BTL', 55.00, '1.5L', 'Orange', 'Bottle', 50, true, 0, NOW(), NOW()),
       (7, 'ROYAL-330ML-CAN', 25.00, '330ml', 'Orange', 'Can', 50, true, 0, NOW(), NOW()),
       (7, 'ROYAL-2L-BTL', 72.00, '2L', 'Orange', 'Bottle', 50, true, 0, NOW(), NOW());

-- 8. Pepsi
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (8, 'PEPSI-8OZ-BTL', 12.00, '8oz', NULL, 'Bottle', 50, true, 0, NOW(), NOW()),
       (8, 'PEPSI-1L-BTL', 35.00, '1L', NULL, 'Bottle', 50, true, 0, NOW(), NOW()),
       (8, 'PEPSI-1.5L-BTL', 55.00, '1.5L', NULL, 'Bottle', 50, true, 0, NOW(), NOW()),
       (8, 'PEPSI-330ML-CAN', 25.00, '330ml', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (8, 'PEPSI-2L-BTL', 72.00, '2L', NULL, 'Bottle', 50, true, 0, NOW(), NOW());

-- 9. Milo
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (9, 'MILO-22G-SACHET', 8.00, '22g', NULL, 'Sachet', 50, true, 0, NOW(), NOW()),
       (9, 'MILO-200G-PACK', 85.00, '200g', NULL, 'Pack', 50, true, 0, NOW(), NOW()),
       (9, 'MILO-400G-TIN', 165.00, '400g', NULL, 'Tin', 50, true, 0, NOW(), NOW()),
       (9, 'MILO-1KG-TIN', 380.00, '1kg', NULL, 'Tin', 50, true, 0, NOW(), NOW()),
       (9, 'MILO-240ML-RTD', 22.00, '240ml', NULL, 'Bottle', 50, true, 0, NOW(), NOW());

-- 10. Nescafe 3in1
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (10, 'NESC-ORIG-20G', 7.00, '20g', 'Original', 'Sachet', 50, true, 0, NOW(), NOW()),
       (10, 'NESC-STRONG-20G', 7.00, '20g', 'Strong', 'Sachet', 50, true, 0, NOW(), NOW()),
       (10, 'NESC-DECAF-20G', 7.00, '20g', 'Decaf', 'Sachet', 50, true, 0, NOW(), NOW()),
       (10, 'NESC-ORIG-10S-BOX', 65.00, '10s', 'Original', 'Box', 50, true, 0, NOW(), NOW()),
       (10, 'NESC-STRONG-10S-BOX', 65.00, '10s', 'Strong', 'Box', 50, true, 0, NOW(), NOW());

-- 11. Bear Brand Milk
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (11, 'BB-MILK-33ML-SACHET', 8.00, '33ml', NULL, 'Sachet', 50, true, 0, NOW(), NOW()),
       (11, 'BB-MILK-155ML-CAN', 22.00, '155ml', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (11, 'BB-MILK-370ML-CAN', 48.00, '370ml', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (11, 'BB-MILK-300ML-BTL', 42.00, '300ml', NULL, 'Bottle', 50, true, 0, NOW(), NOW()),
       (11, 'BB-ADULT-33G-SACHET', 9.00, '33g', 'Adult', 'Sachet', 50, true, 0, NOW(), NOW());

-- 12. Alaska Evaporated Milk
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (12, 'AK-EVAP-155ML-CAN', 18.00, '155ml', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (12, 'AK-EVAP-370ML-CAN', 42.00, '370ml', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (12, 'AK-EVAP-410ML-CAN', 48.00, '410ml', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (12, 'AK-KREAM-155ML-CAN', 22.00, '155ml', 'Kream', 'Can', 50, true, 0, NOW(), NOW()),
       (12, 'AK-CHOCO-155ML-CAN', 22.00, '155ml', 'Chocolate', 'Can', 50, true, 0, NOW(), NOW());

-- 13. Magnolia Ice Cream
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (13, 'MAG-IC-CHOCO-SCOOP', 15.00, '1 scoop', 'Chocolate', 'Cup', 50, true, 0, NOW(), NOW()),
       (13, 'MAG-IC-VAN-SCOOP', 15.00, '1 scoop', 'Vanilla', 'Cup', 50, true, 0, NOW(), NOW()),
       (13, 'MAG-IC-STRAW-SCOOP', 15.00, '1 scoop', 'Strawberry', 'Cup', 50, true, 0, NOW(), NOW()),
       (13, 'MAG-IC-UBE-SCOOP', 15.00, '1 scoop', 'Ube', 'Cup', 50, true, 0, NOW(), NOW()),
       (13, 'MAG-IC-QUESO-SCOOP', 15.00, '1 scoop', 'Queso Real', 'Cup', 50, true, 0, NOW(), NOW());

-- 14. Sky Flakes Crackers
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (14, 'SF-PLAIN-33G', 10.00, '33g', 'Plain', 'Pack', 50, true, 0, NOW(), NOW()),
       (14, 'SF-PLAIN-250G', 55.00, '250g', 'Plain', 'Pack', 50, true, 0, NOW(), NOW()),
       (14, 'SF-CHKN-33G', 10.00, '33g', 'Chicken', 'Pack', 50, true, 0, NOW(), NOW()),
       (14, 'SF-ONION-33G', 10.00, '33g', 'Onion', 'Pack', 50, true, 0, NOW(), NOW()),
       (14, 'SF-PLAIN-10S-BOX', 95.00, '10s', 'Plain', 'Box', 50, true, 0, NOW(), NOW());

-- 15. Rebisco Crackers
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (15, 'REB-PLAIN-33G', 8.00, '33g', 'Plain', 'Pack', 50, true, 0, NOW(), NOW()),
       (15, 'REB-CHEESE-33G', 8.00, '33g', 'Cheese', 'Pack', 50, true, 0, NOW(), NOW()),
       (15, 'REB-CHOCO-33G', 8.00, '33g', 'Chocolate', 'Pack', 50, true, 0, NOW(), NOW()),
       (15, 'REB-PLAIN-250G', 48.00, '250g', 'Plain', 'Pack', 50, true, 0, NOW(), NOW()),
       (15, 'REB-ASSORTED-10S', 75.00, '10s', 'Assorted', 'Box', 50, true, 0, NOW(), NOW());

-- 16. Loaded Chocolate Snack
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (16, 'LOADED-UBE-30G', 15.00, '30g', 'Ube', 'Pack', 50, true, 0, NOW(), NOW()),
       (16, 'LOADED-CHOCO-30G', 15.00, '30g', 'Chocolate', 'Pack', 50, true, 0, NOW(), NOW()),
       (16, 'LOADED-CARAMEL-30G', 15.00, '30g', 'Caramel', 'Pack', 50, true, 0, NOW(), NOW()),
       (16, 'LOADED-UBE-60G', 28.00, '60g', 'Ube', 'Pack', 50, true, 0, NOW(), NOW()),
       (16, 'LOADED-CHOCO-60G', 28.00, '60g', 'Chocolate', 'Pack', 50, true, 0, NOW(), NOW()),
       (16, 'LOADED-CARAMEL-60G', 28.00, '60g', 'Caramel', 'Pack', 50, true, 0, NOW(), NOW());

-- 17. Oishi Prawn Crackers
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (17, 'OISHI-ORIG-60G', 15.00, '60g', 'Original', 'Pack', 50, true, 0, NOW(), NOW()),
       (17, 'OISHI-SPICY-60G', 15.00, '60g', 'Spicy', 'Pack', 50, true, 0, NOW(), NOW()),
       (17, 'OISHI-GARLIC-60G', 15.00, '60g', 'Garlic', 'Pack', 50, true, 0, NOW(), NOW()),
       (17, 'OISHI-ORIG-90G', 22.00, '90g', 'Original', 'Pack', 50, true, 0, NOW(), NOW()),
       (17, 'OISHI-SPICY-90G', 22.00, '90g', 'Spicy', 'Pack', 50, true, 0, NOW(), NOW());

-- 18. Chippy Corn Chips
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (18, 'CHIPPY-BBQ-110G', 22.00, '110g', 'BBQ', 'Pack', 50, true, 0, NOW(), NOW()),
       (18, 'CHIPPY-CHILI-110G', 22.00, '110g', 'Chili Cheese', 'Pack', 50, true, 0, NOW(), NOW()),
       (18, 'CHIPPY-BBQ-55G', 12.00, '55g', 'BBQ', 'Pack', 50, true, 0, NOW(), NOW()),
       (18, 'CHIPPY-CHILI-55G', 12.00, '55g', 'Chili Cheese', 'Pack', 50, true, 0, NOW(), NOW()),
       (18, 'CHIPPY-BBQ-22G', 6.00, '22g', 'BBQ', 'Pack', 50, true, 0, NOW(), NOW());

-- 19. Piattos Chips
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (19, 'PIATTOS-CHEESE-85G', 25.00, '85g', 'Cheese', 'Pack', 50, true, 0, NOW(), NOW()),
       (19, 'PIATTOS-SOUR-85G', 25.00, '85g', 'Sour Cream', 'Pack', 50, true, 0, NOW(), NOW()),
       (19, 'PIATTOS-PIZZA-85G', 25.00, '85g', 'Pizza', 'Pack', 50, true, 0, NOW(), NOW()),
       (19, 'PIATTOS-CHEESE-40G', 14.00, '40g', 'Cheese', 'Pack', 50, true, 0, NOW(), NOW()),
       (19, 'PIATTOS-SOUR-40G', 14.00, '40g', 'Sour Cream', 'Pack', 50, true, 0, NOW(), NOW());

-- 20. Nova Country Cheddar
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (20, 'NOVA-CHEDDAR-78G', 22.00, '78g', 'Country Cheddar', 'Pack', 50, true, 0, NOW(), NOW()),
       (20, 'NOVA-MULTIGRAIN-78G', 22.00, '78g', 'Multigrain', 'Pack', 50, true, 0, NOW(), NOW()),
       (20, 'NOVA-CHEDDAR-30G', 10.00, '30g', 'Country Cheddar', 'Pack', 50, true, 0, NOW(), NOW()),
       (20, 'NOVA-MULTIGRAIN-30G', 10.00, '30g', 'Multigrain', 'Pack', 50, true, 0, NOW(), NOW()),
       (20, 'NOVA-CHEDDAR-22G', 7.00, '22g', 'Country Cheddar', 'Pack', 50, true, 0, NOW(), NOW());

-- 21. Champion Detergent Bar
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (21, 'CHAMP-BAR-90G', 8.00, '90g', NULL, 'Bar', 50, true, 0, NOW(), NOW()),
       (21, 'CHAMP-BAR-180G', 14.00, '180g', NULL, 'Bar', 50, true, 0, NOW(), NOW()),
       (21, 'CHAMP-BAR-350G', 25.00, '350g', NULL, 'Bar', 50, true, 0, NOW(), NOW()),
       (21, 'CHAMP-COLOR-90G', 8.00, '90g', 'Color', 'Bar', 50, true, 0, NOW(), NOW()),
       (21, 'CHAMP-COLOR-180G', 14.00, '180g', 'Color', 'Bar', 50, true, 0, NOW(), NOW());

-- 22. Tide Detergent Powder
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (22, 'TIDE-ORIG-55G-SACHET', 9.00, '55g', 'Original', 'Sachet', 50, true, 0, NOW(), NOW()),
       (22, 'TIDE-ORIG-500G-PACK', 75.00, '500g', 'Original', 'Pack', 50, true, 0, NOW(), NOW()),
       (22, 'TIDE-ORIG-1KG-PACK', 138.00, '1kg', 'Original', 'Pack', 50, true, 0, NOW(), NOW()),
       (22, 'TIDE-COLOR-55G-SACHET', 9.00, '55g', 'Color', 'Sachet', 50, true, 0, NOW(), NOW()),
       (22, 'TIDE-PLUS-55G-SACHET', 10.00, '55g', 'Plus Downy', 'Sachet', 50, true, 0, NOW(), NOW());

-- 23. Ariel Detergent Powder
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (23, 'ARIEL-ORIG-55G-SACHET', 9.00, '55g', 'Original', 'Sachet', 50, true, 0, NOW(), NOW()),
       (23, 'ARIEL-ORIG-500G-PACK', 78.00, '500g', 'Original', 'Pack', 50, true, 0, NOW(), NOW()),
       (23, 'ARIEL-ORIG-1KG-PACK', 145.00, '1kg', 'Original', 'Pack', 50, true, 0, NOW(), NOW()),
       (23, 'ARIEL-COOL-55G-SACHET', 9.00, '55g', 'Cool', 'Sachet', 50, true, 0, NOW(), NOW()),
       (23, 'ARIEL-POD-3S', 45.00, '3s', 'Original', 'Pack', 50, true, 0, NOW(), NOW());

-- 24. Surf Detergent Powder
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (24, 'SURF-55G-SACHET', 8.00, '55g', 'Original', 'Sachet', 50, true, 0, NOW(), NOW()),
       (24, 'SURF-500G-PACK', 65.00, '500g', 'Original', 'Pack', 50, true, 0, NOW(), NOW()),
       (24, 'SURF-1KG-PACK', 118.00, '1kg', 'Original', 'Pack', 50, true, 0, NOW(), NOW()),
       (24, 'SURF-FLORAL-55G-SACHET', 8.00, '55g', 'Floral', 'Sachet', 50, true, 0, NOW(), NOW()),
       (24, 'SURF-BLUE-55G-SACHET', 8.00, '55g', 'Blue', 'Sachet', 50, true, 0, NOW(), NOW());

-- 25. Joy Dishwashing Liquid
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (25, 'JOY-LEMON-15ML-SACHET', 3.00, '15ml', 'Lemon', 'Sachet', 50, true, 0, NOW(), NOW()),
       (25, 'JOY-LEMON-200ML-BTL', 38.00, '200ml', 'Lemon', 'Bottle', 50, true, 0, NOW(), NOW()),
       (25, 'JOY-LEMON-500ML-BTL', 82.00, '500ml', 'Lemon', 'Bottle', 50, true, 0, NOW(), NOW()),
       (25, 'JOY-ORANGE-200ML-BTL', 38.00, '200ml', 'Orange', 'Bottle', 50, true, 0, NOW(), NOW()),
       (25, 'JOY-ANTIBAC-200ML-BTL', 42.00, '200ml', 'Antibacterial', 'Bottle', 50, true, 0, NOW(), NOW());

-- 26. Palmolive Shampoo
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (26, 'PALM-SMOOTH-12ML-SACHET', 6.00, '12ml', 'Smooth', 'Sachet', 50, true, 0, NOW(), NOW()),
       (26, 'PALM-SHINE-12ML-SACHET', 6.00, '12ml', 'Shine', 'Sachet', 50, true, 0, NOW(), NOW()),
       (26, 'PALM-SMOOTH-180ML-BTL', 85.00, '180ml', 'Smooth', 'Bottle', 50, true, 0, NOW(), NOW()),
       (26, 'PALM-SHINE-180ML-BTL', 85.00, '180ml', 'Shine', 'Bottle', 50, true, 0, NOW(), NOW()),
       (26, 'PALM-NATURALS-12ML-SACHET', 6.00, '12ml', 'Naturals', 'Sachet', 50, true, 0, NOW(), NOW());

-- 27. Head and Shoulders
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (27, 'HNS-COOL-12ML-SACHET', 8.00, '12ml', 'Cool Menthol', 'Sachet', 50, true, 0, NOW(), NOW()),
       (27, 'HNS-SMOOTH-12ML-SACHET', 8.00, '12ml', 'Smooth Silk', 'Sachet', 50, true, 0, NOW(), NOW()),
       (27, 'HNS-COOL-180ML-BTL', 155.00, '180ml', 'Cool Menthol', 'Bottle', 50, true, 0, NOW(), NOW()),
       (27, 'HNS-SMOOTH-180ML-BTL', 155.00, '180ml', 'Smooth Silk', 'Bottle', 50, true, 0, NOW(), NOW()),
       (27, 'HNS-ITCHY-12ML-SACHET', 8.00, '12ml', 'Itchy Scalp', 'Sachet', 50, true, 0, NOW(), NOW());

-- 28. Pantene Shampoo
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (28, 'PANT-SMOOTH-12ML-SACHET', 7.00, '12ml', 'Smooth', 'Sachet', 50, true, 0, NOW(), NOW()),
       (28, 'PANT-VOLUME-12ML-SACHET', 7.00, '12ml', 'Volume', 'Sachet', 50, true, 0, NOW(), NOW()),
       (28, 'PANT-SMOOTH-180ML-BTL', 135.00, '180ml', 'Smooth', 'Bottle', 50, true, 0, NOW(), NOW()),
       (28, 'PANT-VOLUME-180ML-BTL', 135.00, '180ml', 'Volume', 'Bottle', 50, true, 0, NOW(), NOW()),
       (28, 'PANT-HAIRFALL-12ML-SACHET', 7.00, '12ml', 'Hairfall Control', 'Sachet', 50, true, 0, NOW(), NOW());

-- 29. Safeguard Soap
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (29, 'SG-WHITE-55G', 18.00, '55g', 'White', 'Bar', 50, true, 0, NOW(), NOW()),
       (29, 'SG-WHITE-90G', 28.00, '90g', 'White', 'Bar', 50, true, 0, NOW(), NOW()),
       (29, 'SG-BLUE-90G', 28.00, '90g', 'Blue', 'Bar', 50, true, 0, NOW(), NOW()),
       (29, 'SG-PINK-90G', 28.00, '90g', 'Pink', 'Bar', 50, true, 0, NOW(), NOW()),
       (29, 'SG-PURE-90G', 30.00, '90g', 'Pure White', 'Bar', 50, true, 0, NOW(), NOW());

-- 30. Dove Soap
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (30, 'DOVE-ORIG-90G', 42.00, '90g', 'Original', 'Bar', 50, true, 0, NOW(), NOW()),
       (30, 'DOVE-PINK-90G', 42.00, '90g', 'Pink', 'Bar', 50, true, 0, NOW(), NOW()),
       (30, 'DOVE-SHEA-90G', 42.00, '90g', 'Shea Butter', 'Bar', 50, true, 0, NOW(), NOW()),
       (30, 'DOVE-ORIG-135G', 58.00, '135g', 'Original', 'Bar', 50, true, 0, NOW(), NOW()),
       (30, 'DOVE-MEN-90G', 42.00, '90g', 'Men Care', 'Bar', 50, true, 0, NOW(), NOW());

-- 31. Colgate Toothpaste
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (31, 'COLG-FRESH-25ML-SACHET', 8.00, '25ml', 'Fresh Cool Mint', 'Sachet', 50, true, 0, NOW(), NOW()),
       (31, 'COLG-FRESH-50ML', 22.00, '50ml', 'Fresh Cool Mint', 'Tube', 50, true, 0, NOW(), NOW()),
       (31, 'COLG-FRESH-100ML', 42.00, '100ml', 'Fresh Cool Mint', 'Tube', 50, true, 0, NOW(), NOW()),
       (31, 'COLG-OPTIC-50ML', 28.00, '50ml', 'Optic White', 'Tube', 50, true, 0, NOW(), NOW()),
       (31, 'COLG-SENSITIVE-50ML', 32.00, '50ml', 'Sensitive', 'Tube', 50, true, 0, NOW(), NOW());

-- 32. Close Up Toothpaste
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (32, 'CU-RED-25ML-SACHET', 7.00, '25ml', 'Red Hot', 'Sachet', 50, true, 0, NOW(), NOW()),
       (32, 'CU-COOL-25ML-SACHET', 7.00, '25ml', 'Cool Mint', 'Sachet', 50, true, 0, NOW(), NOW()),
       (32, 'CU-RED-50ML', 18.00, '50ml', 'Red Hot', 'Tube', 50, true, 0, NOW(), NOW()),
       (32, 'CU-COOL-50ML', 18.00, '50ml', 'Cool Mint', 'Tube', 50, true, 0, NOW(), NOW()),
       (32, 'CU-RED-100ML', 35.00, '100ml', 'Red Hot', 'Tube', 50, true, 0, NOW(), NOW());

-- 33. San Miguel Beer
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (33, 'SMB-PALE-330ML-CAN', 45.00, '330ml', 'Pale Pilsen', 'Can', 50, true, 0, NOW(), NOW()),
       (33, 'SMB-PALE-320ML-BTL', 42.00, '320ml', 'Pale Pilsen', 'Bottle', 50, true, 0, NOW(), NOW()),
       (33, 'SMB-LIGHT-330ML-CAN', 48.00, '330ml', 'Light', 'Can', 50, true, 0, NOW(), NOW()),
       (33, 'SMB-APPLE-330ML-CAN', 52.00, '330ml', 'Apple', 'Can', 50, true, 0, NOW(), NOW()),
       (33, 'SMB-CERVEZA-320ML-BTL', 45.00, '320ml', 'Cerveza Negra', 'Bottle', 50, true, 0, NOW(), NOW());

-- 34. Red Horse Beer
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (34, 'RH-ORIG-330ML-CAN', 52.00, '330ml', 'Original', 'Can', 50, true, 0, NOW(), NOW()),
       (34, 'RH-ORIG-500ML-BTL', 65.00, '500ml', 'Original', 'Bottle', 50, true, 0, NOW(), NOW()),
       (34, 'RH-ORIG-1L-BTL', 118.00, '1L', 'Original', 'Bottle', 50, true, 0, NOW(), NOW()),
       (34, 'RH-BERRY-330ML-CAN', 55.00, '330ml', 'Berry Blast', 'Can', 50, true, 0, NOW(), NOW()),
       (34, 'RH-MANGO-330ML-CAN', 55.00, '330ml', 'Mango', 'Can', 50, true, 0, NOW(), NOW());

-- 35. Tanduay Rum
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (35, 'TDY-5YR-375ML-BTL', 165.00, '375ml', '5 Years', 'Bottle', 50, true, 0, NOW(), NOW()),
       (35, 'TDY-5YR-750ML-BTL', 295.00, '750ml', '5 Years', 'Bottle', 50, true, 0, NOW(), NOW()),
       (35, 'TDY-LIGHT-375ML-BTL', 145.00, '375ml', 'Light', 'Bottle', 50, true, 0, NOW(), NOW()),
       (35, 'TDY-ICE-330ML-CAN', 52.00, '330ml', 'Ice', 'Can', 50, true, 0, NOW(), NOW()),
       (35, 'TDY-RHUM-100ML-BTL', 55.00, '100ml', 'Original', 'Bottle', 50, true, 0, NOW(), NOW());

-- 36. Emperador Brandy
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (36, 'EMP-LIGHT-375ML-BTL', 135.00, '375ml', 'Light', 'Bottle', 50, true, 0, NOW(), NOW()),
       (36, 'EMP-LIGHT-750ML-BTL', 245.00, '750ml', 'Light', 'Bottle', 50, true, 0, NOW(), NOW()),
       (36, 'EMP-ORIG-375ML-BTL', 155.00, '375ml', 'Original', 'Bottle', 50, true, 0, NOW(), NOW()),
       (36, 'EMP-ORIG-750ML-BTL', 275.00, '750ml', 'Original', 'Bottle', 50, true, 0, NOW(), NOW()),
       (36, 'EMP-DOUBLE-375ML-BTL', 185.00, '375ml', 'Double', 'Bottle', 50, true, 0, NOW(), NOW());

-- 37. Marlboro Cigarettes
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (37, 'MARL-RED-1S', 6.00, '1s', 'Red', 'Stick', 50, true, 0, NOW(), NOW()),
       (37, 'MARL-RED-10S', 58.00, '10s', 'Red', 'Pack', 50, true, 0, NOW(), NOW()),
       (37, 'MARL-BLUE-1S', 6.00, '1s', 'Blue', 'Stick', 50, true, 0, NOW(), NOW()),
       (37, 'MARL-BLUE-10S', 58.00, '10s', 'Blue', 'Pack', 50, true, 0, NOW(), NOW()),
       (37, 'MARL-MENTHOL-1S', 6.00, '1s', 'Menthol', 'Stick', 50, true, 0, NOW(), NOW()),
       (37, 'MARL-MENTHOL-10S', 58.00, '10s', 'Menthol', 'Pack', 50, true, 0, NOW(), NOW());

-- 38. Philip Morris Cigarettes
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (38, 'PM-ORIG-1S', 5.00, '1s', 'Original', 'Stick', 50, true, 0, NOW(), NOW()),
       (38, 'PM-ORIG-10S', 48.00, '10s', 'Original', 'Pack', 50, true, 0, NOW(), NOW()),
       (38, 'PM-MENTHOL-1S', 5.00, '1s', 'Menthol', 'Stick', 50, true, 0, NOW(), NOW()),
       (38, 'PM-MENTHOL-10S', 48.00, '10s', 'Menthol', 'Pack', 50, true, 0, NOW(), NOW()),
       (38, 'PM-BLUE-10S', 48.00, '10s', 'Blue', 'Pack', 50, true, 0, NOW(), NOW());

-- 39. Mighty Cigarettes
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (39, 'MIGHTY-RED-1S', 3.00, '1s', 'Red', 'Stick', 50, true, 0, NOW(), NOW()),
       (39, 'MIGHTY-RED-10S', 28.00, '10s', 'Red', 'Pack', 50, true, 0, NOW(), NOW()),
       (39, 'MIGHTY-MENTHOL-1S', 3.00, '1s', 'Menthol', 'Stick', 50, true, 0, NOW(), NOW()),
       (39, 'MIGHTY-MENTHOL-10S', 28.00, '10s', 'Menthol', 'Pack', 50, true, 0, NOW(), NOW()),
       (39, 'MIGHTY-BLUE-10S', 28.00, '10s', 'Blue', 'Pack', 50, true, 0, NOW(), NOW());

-- 40. 555 Sardines
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (40, '555-TOM-155G-CAN', 22.00, '155g', 'Tomato Sauce', 'Can', 50, true, 0, NOW(), NOW()),
       (40, '555-SPICY-155G-CAN', 22.00, '155g', 'Spicy', 'Can', 50, true, 0, NOW(), NOW()),
       (40, '555-LEMON-155G-CAN', 22.00, '155g', 'Lemon', 'Can', 50, true, 0, NOW(), NOW()),
       (40, '555-TOM-255G-CAN', 35.00, '255g', 'Tomato Sauce', 'Can', 50, true, 0, NOW(), NOW()),
       (40, '555-SPICY-255G-CAN', 35.00, '255g', 'Spicy', 'Can', 50, true, 0, NOW(), NOW());

-- 41. Mega Sardines
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (41, 'MEGA-TOM-155G-CAN', 20.00, '155g', 'Tomato Sauce', 'Can', 50, true, 0, NOW(), NOW()),
       (41, 'MEGA-SPICY-155G-CAN', 20.00, '155g', 'Spicy', 'Can', 50, true, 0, NOW(), NOW()),
       (41, 'MEGA-LEMON-155G-CAN', 20.00, '155g', 'Lemon', 'Can', 50, true, 0, NOW(), NOW()),
       (41, 'MEGA-GUISADO-155G-CAN', 20.00, '155g', 'Guisado', 'Can', 50, true, 0, NOW(), NOW()),
       (41, 'MEGA-TOM-220G-CAN', 32.00, '220g', 'Tomato Sauce', 'Can', 50, true, 0, NOW(), NOW());

-- 42. Century Tuna
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (42, 'CT-CHUNKS-155G-CAN', 28.00, '155g', 'Chunks in Oil', 'Can', 50, true, 0, NOW(), NOW()),
       (42, 'CT-HOT-155G-CAN', 28.00, '155g', 'Hot and Spicy', 'Can', 50, true, 0, NOW(), NOW()),
       (42, 'CT-CALDERETA-155G-CAN', 28.00, '155g', 'Caldereta', 'Can', 50, true, 0, NOW(), NOW()),
       (42, 'CT-CHUNKS-180G-POUCH', 32.00, '180g', 'Chunks in Oil', 'Pouch', 50, true, 0, NOW(), NOW()),
       (42, 'CT-HOT-180G-POUCH', 32.00, '180g', 'Hot and Spicy', 'Pouch', 50, true, 0, NOW(), NOW());

-- 43. CDO Meatloaf
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (43, 'CDO-ML-150G-CAN', 38.00, '150g', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (43, 'CDO-ML-230G-CAN', 55.00, '230g', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (43, 'CDO-ML-350G-CAN', 78.00, '350g', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (43, 'CDO-SPICY-150G-CAN', 40.00, '150g', 'Spicy', 'Can', 50, true, 0, NOW(), NOW()),
       (43, 'CDO-CHEESE-150G-CAN', 40.00, '150g', 'Cheese', 'Can', 50, true, 0, NOW(), NOW());

-- 44. Purefoods Corned Beef
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (44, 'PF-CB-85G-CAN', 22.00, '85g', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (44, 'PF-CB-150G-CAN', 38.00, '150g', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (44, 'PF-CB-200G-CAN', 48.00, '200g', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (44, 'PF-CB-260G-CAN', 62.00, '260g', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (44, 'PF-SPICY-150G-CAN', 40.00, '150g', 'Spicy', 'Can', 50, true, 0, NOW(), NOW());

-- 45. UFC Banana Ketchup
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (45, 'UFC-KETCH-20ML-SACHET', 2.00, '20ml', 'Original', 'Sachet', 50, true, 0, NOW(), NOW()),
       (45, 'UFC-KETCH-200G-BTL', 28.00, '200g', 'Original', 'Bottle', 50, true, 0, NOW(), NOW()),
       (45, 'UFC-KETCH-320G-BTL', 42.00, '320g', 'Original', 'Bottle', 50, true, 0, NOW(), NOW()),
       (45, 'UFC-SPICY-200G-BTL', 28.00, '200g', 'Spicy', 'Bottle', 50, true, 0, NOW(), NOW()),
       (45, 'UFC-KETCH-550G-BTL', 65.00, '550g', 'Original', 'Bottle', 50, true, 0, NOW(), NOW());

-- 46. Del Monte Tomato Sauce
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (46, 'DM-TOM-115G-CAN', 18.00, '115g', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (46, 'DM-TOM-250G-CAN', 35.00, '250g', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (46, 'DM-TOM-500G-CAN', 62.00, '500g', NULL, 'Can', 50, true, 0, NOW(), NOW()),
       (46, 'DM-TOM-20ML-SACHET', 5.00, '20ml', NULL, 'Sachet', 50, true, 0, NOW(), NOW()),
       (46, 'DM-SPAG-250G-CAN', 38.00, '250g', 'Spaghetti', 'Can', 50, true, 0, NOW(), NOW());

-- 47. Knorr Seasoning
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (47, 'KNORR-LIQ-7ML-SACHET', 3.00, '7ml', 'Original', 'Sachet', 50, true, 0, NOW(), NOW()),
       (47, 'KNORR-LIQ-100ML-BTL', 38.00, '100ml', 'Original', 'Bottle', 50, true, 0, NOW(), NOW()),
       (47, 'KNORR-LIQ-250ML-BTL', 78.00, '250ml', 'Original', 'Bottle', 50, true, 0, NOW(), NOW()),
       (47, 'KNORR-CUBE-10G', 5.00, '10g', 'Chicken', 'Cube', 50, true, 0, NOW(), NOW()),
       (47, 'KNORR-CUBE-BEEF-10G', 5.00, '10g', 'Beef', 'Cube', 50, true, 0, NOW(), NOW());

-- 48. Magic Sarap
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (48, 'MS-8G-SACHET', 3.00, '8g', NULL, 'Sachet', 50, true, 0, NOW(), NOW()),
       (48, 'MS-18G-SACHET', 6.00, '18g', NULL, 'Sachet', 50, true, 0, NOW(), NOW()),
       (48, 'MS-100G-PACK', 28.00, '100g', NULL, 'Pack', 50, true, 0, NOW(), NOW()),
       (48, 'MS-250G-PACK', 58.00, '250g', NULL, 'Pack', 50, true, 0, NOW(), NOW()),
       (48, 'MS-500G-PACK', 105.00, '500g', NULL, 'Pack', 50, true, 0, NOW(), NOW());

-- 49. Ajinomoto
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (49, 'AJI-7G-SACHET', 3.00, '7g', NULL, 'Sachet', 50, true, 0, NOW(), NOW()),
       (49, 'AJI-18G-SACHET', 6.00, '18g', NULL, 'Sachet', 50, true, 0, NOW(), NOW()),
       (49, 'AJI-100G-PACK', 25.00, '100g', NULL, 'Pack', 50, true, 0, NOW(), NOW()),
       (49, 'AJI-250G-PACK', 52.00, '250g', NULL, 'Pack', 50, true, 0, NOW(), NOW()),
       (49, 'AJI-500G-PACK', 98.00, '500g', NULL, 'Pack', 50, true, 0, NOW(), NOW());

-- 50. White King Detergent
INSERT INTO product_variants (product_id, sku, price, size, flavor, packaging, stock_quantity, active, version,
                              created_at, updated_at)
VALUES (50, 'WK-55G-SACHET', 8.00, '55g', 'Original', 'Sachet', 50, true, 0, NOW(), NOW()),
       (50, 'WK-500G-PACK', 65.00, '500g', 'Original', 'Pack', 50, true, 0, NOW(), NOW()),
       (50, 'WK-1KG-PACK', 118.00, '1kg', 'Original', 'Pack', 50, true, 0, NOW(), NOW()),
       (50, 'WK-COLOR-55G-SACHET', 8.00, '55g', 'Color', 'Sachet', 50, true, 0, NOW(), NOW()),
       (50, 'WK-POWER-55G-SACHET', 9.00, '55g', 'Power White', 'Sachet', 50, true, 0, NOW(), NOW());

-- ============================================================
-- GCASH FEE TIERS
-- ============================================================
INSERT INTO gcash_fee_tiers (minimum_amount, maximum_amount, fee, created_at, updated_at)
VALUES (1.00, 500.00, 0.00, NOW(), NOW()),
       (501.00, 1000.00, 10.00, NOW(), NOW()),
       (1001.00, 3000.00, 15.00, NOW(), NOW()),
       (3001.00, 5000.00, 20.00, NOW(), NOW());

-- ============================================================
-- STOCK MOVEMENTS (initial restock - first 20 variants)
-- ============================================================
INSERT INTO stock_movements (variant_id, transaction_id, reason, quantity_change, notes, created_at)
VALUES (1, NULL, 'RESTOCK', 50, 'Initial stock', NOW()),
       (2, NULL, 'RESTOCK', 50, 'Initial stock', NOW()),
       (3, NULL, 'RESTOCK', 50, 'Initial stock', NOW()),
       (4, NULL, 'RESTOCK', 50, 'Initial stock', NOW()),
       (5, NULL, 'RESTOCK', 50, 'Initial stock', NOW()),
       (6, NULL, 'RESTOCK', 50, 'Initial stock', NOW()),
       (7, NULL, 'RESTOCK', 50, 'Initial stock', NOW()),
       (8, NULL, 'RESTOCK', 50, 'Initial stock', NOW()),
       (9, NULL, 'RESTOCK', 50, 'Initial stock', NOW()),
       (10, NULL, 'RESTOCK', 50, 'Initial stock', NOW()),
       (11, NULL, 'RESTOCK', 50, 'Initial stock', NOW()),
       (12, NULL, 'RESTOCK', 50, 'Initial stock', NOW()),
       (13, NULL, 'RESTOCK', 50, 'Initial stock', NOW()),
       (14, NULL, 'RESTOCK', 50, 'Initial stock', NOW()),
       (15, NULL, 'RESTOCK', 50, 'Initial stock', NOW()),
       (16, NULL, 'RESTOCK', 50, 'Initial stock', NOW()),
       (17, NULL, 'RESTOCK', 50, 'Initial stock', NOW()),
       (18, NULL, 'RESTOCK', 50, 'Initial stock', NOW()),
       (19, NULL, 'RESTOCK', 50, 'Initial stock', NOW()),
       (20, NULL, 'RESTOCK', 50, 'Initial stock', NOW());

-- ============================================================
-- TRANSACTIONS
-- Variant prices reference:
--   1  = COKE-8OZ-BTL     = 12.00
--   2  = COKE-1L-BTL      = 35.00
--   7  = LM-CHKN-55G      =  9.00
--   8  = LM-BEEF-55G      =  9.00
--   9  = LM-PORK-55G      =  9.00
--   11 = ARG-CB-85G-CAN   = 22.00
--   12 = ARG-CB-150G-CAN  = 38.00
--   16 = NESC-ORIG-20G    =  7.00  (variant 16 of product 10)
--   17 = NESC-STRONG-20G  =  7.00
--   26 = BB-MILK-33ML     =  8.00  (variant 26 of product 11)
-- ============================================================

-- Transaction 1: Maria Santos (customer 1) - full CASH payment
-- Items: 3x Coke 8oz (12*3=36) + 2x LM Chicken (9*2=18) = 54.00
INSERT INTO transactions (customer_id, total_amount, representative, notes, created_at)
VALUES (1, 54.00, NULL, NULL, NOW() - INTERVAL '6 days');

INSERT INTO transaction_items (transaction_id, product_variant_id, quantity, unit_price, created_at)
VALUES (1, 1, 3, 12.00, NOW() - INTERVAL '6 days'),
       (1, 7, 2, 9.00, NOW() - INTERVAL '6 days');

INSERT INTO transaction_payments (transaction_id, method, amount, created_at)
VALUES (1, 'CASH', 54.00, NOW() - INTERVAL '6 days');

INSERT INTO stock_movements (variant_id, transaction_id, reason, quantity_change, notes, created_at)
VALUES (1, 1, 'SOLD', -3, NULL, NOW() - INTERVAL '6 days'),
       (7, 1, 'SOLD', -2, NULL, NOW() - INTERVAL '6 days');

-- Transaction 2: Maria Santos (customer 1) - partial payment (DEBT)
-- Items: 2x Coke 1L (35*2=70) + 1x ARG-CB-85G (22) = 92.00, paid 50.00, debt 42.00
INSERT INTO transactions (customer_id, total_amount, representative, notes, created_at)
VALUES (1, 92.00, NULL, 'Partial payment', NOW() - INTERVAL '5 days');

INSERT INTO transaction_items (transaction_id, product_variant_id, quantity, unit_price, created_at)
VALUES (2, 2, 2, 35.00, NOW() - INTERVAL '5 days'),
       (2, 11, 1, 22.00, NOW() - INTERVAL '5 days');

INSERT INTO transaction_payments (transaction_id, method, amount, created_at)
VALUES (2, 'CASH', 50.00, NOW() - INTERVAL '5 days');

INSERT INTO debt_ledgers (customer_id, transaction_id, amount, "type", payment_method, notes, created_at)
VALUES (1, 2, 42.00, 'DEBT', NULL, NULL, NOW() - INTERVAL '5 days');

INSERT INTO stock_movements (variant_id, transaction_id, reason, quantity_change, notes, created_at)
VALUES (2, 2, 'SOLD', -2, NULL, NOW() - INTERVAL '5 days'),
       (11, 2, 'SOLD', -1, NULL, NOW() - INTERVAL '5 days');

-- Transaction 3: Maria Santos (customer 1) - overpayment stored as CREDIT
-- Items: 1x LM Chicken (9) + 1x LM Beef (9) = 18.00, paid 50.00, credit 32.00
INSERT INTO transactions (customer_id, total_amount, representative, notes, created_at)
VALUES (1, 18.00, NULL, NULL, NOW() - INTERVAL '4 days');

INSERT INTO transaction_items (transaction_id, product_variant_id, quantity, unit_price, created_at)
VALUES (3, 7, 1, 9.00, NOW() - INTERVAL '4 days'),
       (3, 8, 1, 9.00, NOW() - INTERVAL '4 days');

INSERT INTO transaction_payments (transaction_id, method, amount, created_at)
VALUES (3, 'CASH', 50.00, NOW() - INTERVAL '4 days');

INSERT INTO debt_ledgers (customer_id, transaction_id, amount, "type", payment_method, notes, created_at)
VALUES (1, 3, 32.00, 'CREDIT', NULL, NULL, NOW() - INTERVAL '4 days');

INSERT INTO stock_movements (variant_id, transaction_id, reason, quantity_change, notes, created_at)
VALUES (7, 3, 'SOLD', -1, NULL, NOW() - INTERVAL '4 days'),
       (8, 3, 'SOLD', -1, NULL, NOW() - INTERVAL '4 days');

-- Transaction 4: Jose Reyes (customer 2) - full GCASH payment
-- Items: 1x Coke 1L (35) + 2x LM Pork (9*2=18) = 53.00
INSERT INTO transactions (customer_id, total_amount, representative, notes, created_at)
VALUES (2, 53.00, NULL, NULL, NOW() - INTERVAL '5 days');

INSERT INTO transaction_items (transaction_id, product_variant_id, quantity, unit_price, created_at)
VALUES (4, 2, 1, 35.00, NOW() - INTERVAL '5 days'),
       (4, 9, 2, 9.00, NOW() - INTERVAL '5 days');

INSERT INTO transaction_payments (transaction_id, method, amount, created_at)
VALUES (4, 'GCASH', 53.00, NOW() - INTERVAL '5 days');

INSERT INTO stock_movements (variant_id, transaction_id, reason, quantity_change, notes, created_at)
VALUES (2, 4, 'SOLD', -1, NULL, NOW() - INTERVAL '5 days'),
       (9, 4, 'SOLD', -2, NULL, NOW() - INTERVAL '5 days');

-- Transaction 5: Jose Reyes (customer 2) - full DEBT (no payment)
-- Items: 3x LM Chicken (9*3=27) + 1x ARG-CB-150G (38) = 65.00
INSERT INTO transactions (customer_id, total_amount, representative, notes, created_at)
VALUES (2, 65.00, NULL, 'Full utang', NOW() - INTERVAL '4 days');

INSERT INTO transaction_items (transaction_id, product_variant_id, quantity, unit_price, created_at)
VALUES (5, 7, 3, 9.00, NOW() - INTERVAL '4 days'),
       (5, 12, 1, 38.00, NOW() - INTERVAL '4 days');

INSERT INTO transaction_payments (transaction_id, method, amount, created_at)
VALUES (5, 'CASH', 0.00, NOW() - INTERVAL '4 days');

INSERT INTO debt_ledgers (customer_id, transaction_id, amount, "type", payment_method, notes, created_at)
VALUES (2, 5, 65.00, 'DEBT', NULL, NULL, NOW() - INTERVAL '4 days');

INSERT INTO stock_movements (variant_id, transaction_id, reason, quantity_change, notes, created_at)
VALUES (7, 5, 'SOLD', -3, NULL, NOW() - INTERVAL '4 days'),
       (12, 5, 'SOLD', -1, NULL, NOW() - INTERVAL '4 days');

-- Transaction 6: Ana Cruz (customer 3) - full cash
-- Items: 2x Coke 8oz (12*2=24) + 3x LM Beef (9*3=27) = 51.00
INSERT INTO transactions (customer_id, total_amount, representative, notes, created_at)
VALUES (3, 51.00, NULL, NULL, NOW() - INTERVAL '4 days');

INSERT INTO transaction_items (transaction_id, product_variant_id, quantity, unit_price, created_at)
VALUES (6, 1, 2, 12.00, NOW() - INTERVAL '4 days'),
       (6, 8, 3, 9.00, NOW() - INTERVAL '4 days');

INSERT INTO transaction_payments (transaction_id, method, amount, created_at)
VALUES (6, 'CASH', 51.00, NOW() - INTERVAL '4 days');

INSERT INTO stock_movements (variant_id, transaction_id, reason, quantity_change, notes, created_at)
VALUES (1, 6, 'SOLD', -2, NULL, NOW() - INTERVAL '4 days'),
       (8, 6, 'SOLD', -3, NULL, NOW() - INTERVAL '4 days');

-- Transaction 7: Ana Cruz (customer 3) - partial payment
-- Items: 1x Coke 1L (35) + 2x ARG-CB-85G (22*2=44) = 79.00, paid 30.00, debt 49.00
INSERT INTO transactions (customer_id, total_amount, representative, notes, created_at)
VALUES (3, 79.00, NULL, NULL, NOW() - INTERVAL '3 days');

INSERT INTO transaction_items (transaction_id, product_variant_id, quantity, unit_price, created_at)
VALUES (7, 2, 1, 35.00, NOW() - INTERVAL '3 days'),
       (7, 11, 2, 22.00, NOW() - INTERVAL '3 days');

INSERT INTO transaction_payments (transaction_id, method, amount, created_at)
VALUES (7, 'CASH', 30.00, NOW() - INTERVAL '3 days');

INSERT INTO debt_ledgers (customer_id, transaction_id, amount, "type", payment_method, notes, created_at)
VALUES (3, 7, 49.00, 'DEBT', NULL, NULL, NOW() - INTERVAL '3 days');

INSERT INTO stock_movements (variant_id, transaction_id, reason, quantity_change, notes, created_at)
VALUES (2, 7, 'SOLD', -1, NULL, NOW() - INTERVAL '3 days'),
       (11, 7, 'SOLD', -2, NULL, NOW() - INTERVAL '3 days');

-- Transaction 8: Pedro Dela Cruz (customer 4) - mixed CASH + GCASH
-- Items: 4x Coke 8oz (12*4=48) + 2x LM Pork (9*2=18) = 66.00
INSERT INTO transactions (customer_id, total_amount, representative, notes, created_at)
VALUES (4, 66.00, NULL, NULL, NOW() - INTERVAL '3 days');

INSERT INTO transaction_items (transaction_id, product_variant_id, quantity, unit_price, created_at)
VALUES (8, 1, 4, 12.00, NOW() - INTERVAL '3 days'),
       (8, 9, 2, 9.00, NOW() - INTERVAL '3 days');

INSERT INTO transaction_payments (transaction_id, method, amount, created_at)
VALUES (8, 'CASH', 36.00, NOW() - INTERVAL '3 days'),
       (8, 'GCASH', 30.00, NOW() - INTERVAL '3 days');

INSERT INTO stock_movements (variant_id, transaction_id, reason, quantity_change, notes, created_at)
VALUES (1, 8, 'SOLD', -4, NULL, NOW() - INTERVAL '3 days'),
       (9, 8, 'SOLD', -2, NULL, NOW() - INTERVAL '3 days');

-- Transaction 9: Rosa Garcia (customer 5) - full cash
-- Items: 2x LM Chicken (9*2=18) + 1x Coke 1L (35) = 53.00
INSERT INTO transactions (customer_id, total_amount, representative, notes, created_at)
VALUES (5, 53.00, NULL, NULL, NOW() - INTERVAL '2 days');

INSERT INTO transaction_items (transaction_id, product_variant_id, quantity, unit_price, created_at)
VALUES (9, 7, 2, 9.00, NOW() - INTERVAL '2 days'),
       (9, 2, 1, 35.00, NOW() - INTERVAL '2 days');

INSERT INTO transaction_payments (transaction_id, method, amount, created_at)
VALUES (9, 'CASH', 53.00, NOW() - INTERVAL '2 days');

INSERT INTO stock_movements (variant_id, transaction_id, reason, quantity_change, notes, created_at)
VALUES (7, 9, 'SOLD', -2, NULL, NOW() - INTERVAL '2 days'),
       (2, 9, 'SOLD', -1, NULL, NOW() - INTERVAL '2 days');

-- Transaction 10: Rosa Garcia (customer 5) - full DEBT
-- Items: 3x Coke 8oz (12*3=36) + 1x ARG-CB-150G (38) = 74.00
INSERT INTO transactions (customer_id, total_amount, representative, notes, created_at)
VALUES (5, 74.00, NULL, 'Full utang', NOW() - INTERVAL '2 days');

INSERT INTO transaction_items (transaction_id, product_variant_id, quantity, unit_price, created_at)
VALUES (10, 1, 3, 12.00, NOW() - INTERVAL '2 days'),
       (10, 12, 1, 38.00, NOW() - INTERVAL '2 days');

INSERT INTO transaction_payments (transaction_id, method, amount, created_at)
VALUES (10, 'CASH', 0.00, NOW() - INTERVAL '2 days');

INSERT INTO debt_ledgers (customer_id, transaction_id, amount, "type", payment_method, notes, created_at)
VALUES (5, 10, 74.00, 'DEBT', NULL, NULL, NOW() - INTERVAL '2 days');

INSERT INTO stock_movements (variant_id, transaction_id, reason, quantity_change, notes, created_at)
VALUES (1, 10, 'SOLD', -3, NULL, NOW() - INTERVAL '2 days'),
       (12, 10, 'SOLD', -1, NULL, NOW() - INTERVAL '2 days');

-- Transaction 11: Juan Mendoza (customer 6) - full GCASH
-- Items: 5x LM Chicken (9*5=45) = 45.00
INSERT INTO transactions (customer_id, total_amount, representative, notes, created_at)
VALUES (6, 45.00, NULL, NULL, NOW() - INTERVAL '1 day');

INSERT INTO transaction_items (transaction_id, product_variant_id, quantity, unit_price, created_at)
VALUES (11, 7, 5, 9.00, NOW() - INTERVAL '1 day');

INSERT INTO transaction_payments (transaction_id, method, amount, created_at)
VALUES (11, 'GCASH', 45.00, NOW() - INTERVAL '1 day');

INSERT INTO stock_movements (variant_id, transaction_id, reason, quantity_change, notes, created_at)
VALUES (7, 11, 'SOLD', -5, NULL, NOW() - INTERVAL '1 day');

-- Transaction 12: Maria Santos (customer 1) - today's transaction
-- Items: 1x Coke 8oz (12) + 1x LM Pork (9) = 21.00
INSERT INTO transactions (customer_id, total_amount, representative, notes, created_at)
VALUES (1, 21.00, NULL, NULL, NOW());

INSERT INTO transaction_items (transaction_id, product_variant_id, quantity, unit_price, created_at)
VALUES (12, 1, 1, 12.00, NOW()),
       (12, 9, 1, 9.00, NOW());

INSERT INTO transaction_payments (transaction_id, method, amount, created_at)
VALUES (12, 'CASH', 21.00, NOW());

INSERT INTO stock_movements (variant_id, transaction_id, reason, quantity_change, notes, created_at)
VALUES (1, 12, 'SOLD', -1, NULL, NOW()),
       (9, 12, 'SOLD', -1, NULL, NOW());

-- Transaction 13: Jose Reyes (customer 2) - today's transaction with GCASH
-- Items: 2x Coke 1L (35*2=70) = 70.00
INSERT INTO transactions (customer_id, total_amount, representative, notes, created_at)
VALUES (2, 70.00, NULL, NULL, NOW());

INSERT INTO transaction_items (transaction_id, product_variant_id, quantity, unit_price, created_at)
VALUES (13, 2, 2, 35.00, NOW());

INSERT INTO transaction_payments (transaction_id, method, amount, created_at)
VALUES (13, 'GCASH', 70.00, NOW());

INSERT INTO stock_movements (variant_id, transaction_id, reason, quantity_change, notes, created_at)
VALUES (2, 13, 'SOLD', -2, NULL, NOW());

-- Transaction 14: Walk-in (no customer) - cash
-- Items: 3x LM Beef (9*3=27) = 27.00
INSERT INTO transactions (customer_id, total_amount, representative, notes, created_at)
VALUES (NULL, 27.00, 'Kuya Boy', NULL, NOW());

INSERT INTO transaction_items (transaction_id, product_variant_id, quantity, unit_price, created_at)
VALUES (14, 8, 3, 9.00, NOW());

INSERT INTO transaction_payments (transaction_id, method, amount, created_at)
VALUES (14, 'CASH', 27.00, NOW());

INSERT INTO stock_movements (variant_id, transaction_id, reason, quantity_change, notes, created_at)
VALUES (8, 14, 'SOLD', -3, NULL, NOW());

-- Transaction 15: Ana Cruz (customer 3) - debt payment via transaction
-- Items: 2x Coke 8oz (12*2=24) = 24.00, paid 24.00 (fully paid)
INSERT INTO transactions (customer_id, total_amount, representative, notes, created_at)
VALUES (3, 24.00, NULL, NULL, NOW());

INSERT INTO transaction_items (transaction_id, product_variant_id, quantity, unit_price, created_at)
VALUES (15, 1, 2, 12.00, NOW());

INSERT INTO transaction_payments (transaction_id, method, amount, created_at)
VALUES (15, 'CASH', 24.00, NOW());

INSERT INTO stock_movements (variant_id, transaction_id, reason, quantity_change, notes, created_at)
VALUES (1, 15, 'SOLD', -2, NULL, NOW());

-- ============================================================
-- DEBT PAYMENTS (paying off existing debts)
-- ============================================================

-- Maria Santos pays 20.00 toward her 42.00 debt (transaction 2)
INSERT INTO debt_ledgers (customer_id, transaction_id, amount, "type", payment_method, notes, created_at)
VALUES (1, NULL, 20.00, 'PAYMENT', 'CASH', 'Partial payment on debt', NOW() - INTERVAL '3 days');

-- Jose Reyes pays 65.00 full debt (transaction 5)
INSERT INTO debt_ledgers (customer_id, transaction_id, amount, "type", payment_method, notes, created_at)
VALUES (2, NULL, 65.00, 'PAYMENT', 'GCASH', 'Full debt payment', NOW() - INTERVAL '2 days');

-- Rosa Garcia pays 30.00 toward her 74.00 debt (transaction 10)
INSERT INTO debt_ledgers (customer_id, transaction_id, amount, "type", payment_method, notes, created_at)
VALUES (5, NULL, 30.00, 'PAYMENT', 'CASH', 'Partial debt payment', NOW() - INTERVAL '1 day');

-- ============================================================
-- GCASH SERVICE LOGS
-- ============================================================
INSERT INTO gcash_service_logs (customer_id, representative_name, representative_phone, service_type, amount, fee,
                                notes, created_at)
VALUES (1, NULL, '09171234567', 'CASH_IN', 300.00, 0.00, 'Cash-in for Maria', NOW() - INTERVAL '5 days'),
       (2, NULL, '09182345678', 'CASH_IN', 750.00, 10.00, 'Cash-in for Jose', NOW() - INTERVAL '4 days'),
       (NULL, 'Juan dela Cruz', '09991234567', 'CASH_IN', 500.00, 0.00, NULL, NOW() - INTERVAL '3 days'),
       (3, NULL, '09193456789', 'CASH_OUT', 200.00, 0.00, 'Cash-out for Ana', NOW() - INTERVAL '3 days'),
       (NULL, 'Ate Nena', '09881234567', 'CASH_IN', 1500.00, 15.00, NULL, NOW() - INTERVAL '2 days'),
       (4, NULL, '09204567890', 'CASH_OUT', 800.00, 10.00, 'Cash-out for Pedro', NOW() - INTERVAL '1 day'),
       (5, NULL, '09215678901', 'CASH_IN', 250.00, 0.00, 'Cash-in for Rosa', NOW()),
       (NULL, 'Kuya Ben', '09771234567', 'CASH_IN', 400.00, 0.00, NULL, NOW());