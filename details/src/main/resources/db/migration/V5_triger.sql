CREATE function update_count_function () RETURNS TRIGGER AS $$
BEGIN
  UPDATE details
  SET
    count = count - NEW.count
  WHERE
    id = NEW.detail_id;
  return NEW;
END;
$$ language plpgsql;

CREATE TRIGGER update_count_after_insert
AFTER INSERT ON sells FOR EACH ROW WHEN (new.is_paid = true)
EXECUTE function update_count_function ();
CREATE TRIGGER update_count_after_update
AFTER UPDATE ON sells FOR EACH ROW WHEN (new.is_paid = true)
EXECUTE function update_count_function ();