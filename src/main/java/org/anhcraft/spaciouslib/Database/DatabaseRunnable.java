package org.anhcraft.spaciouslib.Database;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Copyright (c) by Anh Craft. All rights reserved.
 * Licensed under the apache license v2.0.
 */
public interface DatabaseRunnable {
    void run(Connection c, Statement s);
}
