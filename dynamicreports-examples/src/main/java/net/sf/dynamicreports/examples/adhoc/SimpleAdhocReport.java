/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.dynamicreports.examples.adhoc;

import net.sf.dynamicreports.adhoc.AdhocManager;
import net.sf.dynamicreports.adhoc.configuration.AdhocColumn;
import net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration;
import net.sf.dynamicreports.adhoc.configuration.AdhocReport;
import net.sf.dynamicreports.adhoc.transformation.AdhocToXmlTransform;
import net.sf.dynamicreports.adhoc.transformation.XmlToAdhocTransform;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.stream.IntStream;

/**
 * <p>SimpleAdhocReport class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class SimpleAdhocReport {

    /**
     * <p>Constructor for SimpleAdhocReport.</p>
     */
    public SimpleAdhocReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new SimpleAdhocReport();
    }

    private void build() {

        AdhocManager adhocManager = AdhocManager.getInstance(new AdhocToXmlTransform(), new XmlToAdhocTransform());

        AdhocConfiguration configuration = new AdhocConfiguration();
        AdhocReport report = new AdhocReport();
        configuration.setReport(report);

        AdhocColumn column = new AdhocColumn();
        column.setName("item");
        report.addColumn(column);

        column = new AdhocColumn();
        column.setName("quantity");
        report.addColumn(column);

        try {
            // The following code stores the configuration to an xml file
            adhocManager.saveConfiguration(configuration, new FileOutputStream("c:/temp/configuration.xml"));
            @SuppressWarnings("unused")
            // The following code loads a configuration from an xml file
                AdhocConfiguration loadedConfiguration = adhocManager.loadConfiguration(new FileInputStream("c:/temp/configuration.xml"));

            JasperReportBuilder reportBuilder = adhocManager.createReport(configuration.getReport());
            reportBuilder.setDataSource(createDataSource());
            reportBuilder.show();
        } catch (DRException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "orderdate", "quantity", "unitprice");
        IntStream.range(0, 20).forEach(i -> dataSource.add("Book # " + i, Date.from(Instant.now()), (int) (Math.random() * 10) + 1, BigDecimal.valueOf(Math.random() * 100 + 1)));
        return dataSource;
    }
}
