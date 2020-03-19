/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
 * http://www.dynamicreports.org
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General License for more details.
 *
 * You should have received a copy of the GNU Lesser General License
 * along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.dynamicreports.googlecharts.report.geomap;

import net.sf.dynamicreports.report.definition.DRIDataset;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import java.io.Serializable;

/**
 * <p>DRIGeoMapDataset interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public interface DRIGeoMapDataset extends Serializable {

    /**
     * <p>getSubDataset.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.DRIDataset} object.
     */
    DRIDataset getSubDataset();

    /**
     * <p>getLocationExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    DRIExpression<?> getLocationExpression();

    /**
     * <p>getValueExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    DRIExpression<?> getValueExpression();

    /**
     * <p>getLabelExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    DRIExpression<?> getLabelExpression();
}
