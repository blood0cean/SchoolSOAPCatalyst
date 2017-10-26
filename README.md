# SchoolSOAPCatalyst
SOAP client that will be connected from Catalyst, this is a simple example that adds a register to Teacher table and retrieves the list.

## Requirements

* Java
* MySQL

## Installation

* Download the example project.
* This can be imported into Eclipse.
* Run TeacherPublisher class, this will set up the server on http://localhost:9999/ws/school
* You can verify the WSDL formed in [http://localhost:9999/ws/school?wsdl]()
* The database can be created using *db/Dump20160114.sql*
* Make sure to have the connector in your classpath.
* The credentials are defined in TeacherImpl class.
* The structure Teacher can be imported to Catalyst using the file *catalyst/Catalyst-14Jan2016-23h46m44s.json*, this also contains the form to add and the table to list records.
