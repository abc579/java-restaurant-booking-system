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
    public Optional<List<Table>> findAvailableTables(final String startDate, final String endDate) {
        List<Table> tables = jdbcTemplate.query("select id, seats from tables t where t.seats >= ? and not exist (select 1 from reservations r where r.table_id = t.table_id and ? > r.start_time and ? < r.end_time)",
                                                (rs, rowNum) -> {
                                                    try {
                                                        final TableId id = new TableId(rs.getString("id"));
                                                        final TableSeats seats = new TableSeats(rs.getString("seats"));
                                                        return new Table(id, seats);
                                                    } catch (final Exception ex) {
                                                        return null;
                                                    }
                                                }, startDate, endDate);

        return Optional.ofNullable(tables);
    }
}
