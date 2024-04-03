CREATE OR REPLACE FUNCTION update_details_function()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE details
    SET count = count - NEW.count
    WHERE id = NEW.detail_id;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_count
AFTER INSERT ON sells
FOR EACH ROW
EXECUTE PROCEDURE update_details_function();