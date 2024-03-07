package com.roccatagliatta.restaurant.Reservation.Infrastructure.Persistence;

import java.util.List;
import java.util.Optional;

import com.roccatagliatta.restaurant.Reservation.Domain.Persistence.TableRepository;
import com.roccatagliatta.restaurant.Reservation.Domain.Table;
import com.roccatagliatta.restaurant.Reservation.Domain.Value.TableId;
import com.roccatagliatta.restaurant.Reservation.Domain.Value.TableSeats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public final class MySQLTableRepository implements TableRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Table> findAvailableTables(String startDate, String endDate, int seats) {
        List<Table> tables = jdbcTemplate.
            query("select id, seats from tables t where t.seats >= ? and not exists (select 1 from reservations r where r.table_id = t.id and ((? between convert_tz(r.start_time, '+00:00', '+00:00') and convert_tz(r.end_time, '+00:00', '+00:00') or ? between convert_tz(r.start_time, '+00:00', '+00:00') and convert_tz(r.end_time, '+00:00', '+00:00')) or (? <= r.start_time and ? >= r.end_time)))",
                  (rs, rowNum) -> {
                      try {
                          final TableId id = new TableId(rs.getString("id"));
                          final TableSeats seatsDb = new TableSeats(rs.getString("seats"));
                          return new Table(id, seatsDb);
                      } catch (final Exception ex) {
                          return null;
                      }
        }, seats, startDate, endDate, startDate, endDate);

        return tables;
    }
}
