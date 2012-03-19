/*
 * This file is part of the 3D City Database Importer/Exporter.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.gis.tu-berlin.de/
 * 
 * The 3D City Database Importer/Exporter program is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program. If not, see 
 * <http://www.gnu.org/licenses/>.
 * 
 * The development of the 3D City Database Importer/Exporter has 
 * been financially supported by the following cooperation partners:
 * 
 * Business Location Center, Berlin <http://www.businesslocationcenter.de/>
 * virtualcitySYSTEMS GmbH, Berlin <http://www.virtualcitysystems.de/>
 * Berlin Senate of Business, Technology and Women <http://www.berlin.de/sen/wtf/>
 */
package de.tub.citydb.gui.components.mapviewer.map.event;

import de.tub.citydb.api.event.Event;
import de.tub.citydb.gui.components.mapviewer.geocoder.GeocoderResponse;
import de.tub.citydb.gui.components.mapviewer.geocoder.Location;

public class ReverseGeocoderEvent extends Event {
	private final ReverseGeocoderStatus status;
	private final Location location;
	private final GeocoderResponse response;
	
	public enum ReverseGeocoderStatus {
		SEARCHING,
		RESULT,
		ERROR
	}	
	
	public ReverseGeocoderEvent(Object source) {
		super(MapEvents.REVERSE_GEOCODER, source);
		this.status = ReverseGeocoderStatus.SEARCHING;
		location = null;
		response = null;
	}
	
	public ReverseGeocoderEvent(Location location, Object source) {
		super(MapEvents.REVERSE_GEOCODER, source);
		this.status = ReverseGeocoderStatus.RESULT;
		this.location = location;
		response = null;
	}
	
	public ReverseGeocoderEvent(GeocoderResponse response, Object source) {
		super(MapEvents.REVERSE_GEOCODER, source);
		this.status = ReverseGeocoderStatus.ERROR;
		location = null;
		this.response = response;
	}

	public ReverseGeocoderStatus getStatus() {
		return status;
	}

	public Location getLocation() {
		return location;
	}

	public GeocoderResponse getResponse() {
		return response;
	}
	
}
