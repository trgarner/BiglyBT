/*
 * Created on 15-Jun-2004
 * Created by Paul Gardner
 * Copyright (C) Azureus Software, Inc, All Rights Reserved.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 */

package com.biglybt.net.upnp.impl.services;

/**
 * @author parg
 *
 */

import com.biglybt.net.upnp.UPnPAction;
import com.biglybt.net.upnp.UPnPActionInvocation;
import com.biglybt.net.upnp.UPnPService;
import com.biglybt.pif.utils.xml.simpleparser.SimpleXMLParserDocumentNode;

public class
UPnPActionImpl
	implements UPnPAction
{
	protected UPnPServiceImpl		service;
	protected String				name;

	protected
	UPnPActionImpl(
		UPnPServiceImpl					_service,
		SimpleXMLParserDocumentNode		node )
	{
		service	= _service;

		name	= node.getChild( "name" ).getValue().trim();
	}

	@Override
	public String
	getName()
	{
		return( name );
	}

	@Override
	public UPnPService
	getService()
	{
		return( service );
	}

	@Override
	public UPnPActionInvocation
	getInvocation()
	{
		return( new UPnPActionInvocationImpl( this ));
	}
}
