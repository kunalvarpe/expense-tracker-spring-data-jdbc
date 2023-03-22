-- User Info
CREATE TABLE IF NOT EXISTS user_info (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(20),
	last_name VARCHAR(20)
);

CREATE INDEX IF NOT EXISTS last_name_idx ON user_info (last_name);

--  Expense
CREATE TABLE IF NOT EXISTS expenses (
	id SERIAL PRIMARY KEY,
	name VARCHAR(30) NOT NULL,
	category VARCHAR(30),
	created_at TIMESTAMP,
	updated_at TIMESTAMP,
	amount NUMERIC(10, 2) NOT NULL,
	currency VARCHAR(3),
	user_id INTEGER NOT NULL,
	FOREIGN KEY (user_id) REFERENCES user_info (id)
);
CREATE INDEX IF NOT EXISTS name_category_idx ON expenses (name, category);

