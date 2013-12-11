/**
 * This class is generated by jOOQ
 */
package io.github.ibuildthecloud.dstack.db.jooq.generated.model;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
@javax.persistence.Entity
@javax.persistence.Table(name = "vnet", schema = "dstack")
public interface Vnet extends java.io.Serializable {

	/**
	 * Getter for <code>dstack.vnet.id</code>. 
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 19)
	public java.lang.Long getId();

	/**
	 * Getter for <code>dstack.vnet.uri</code>. 
	 */
	@javax.persistence.Column(name = "uri", nullable = false, length = 128)
	public java.lang.String getUri();

	/**
	 * Getter for <code>dstack.vnet.scope</code>. 
	 */
	@javax.persistence.Column(name = "scope", nullable = false, length = 128)
	public java.lang.String getScope();

	/**
	 * Getter for <code>dstack.vnet.ip_pool_qualifier</code>. 
	 */
	@javax.persistence.Column(name = "ip_pool_qualifier", length = 128)
	public java.lang.String getIpPoolQualifier();

	/**
	 * Getter for <code>dstack.vnet.ip_pool_segment</code>. 
	 */
	@javax.persistence.Column(name = "ip_pool_segment", length = 128)
	public java.lang.String getIpPoolSegment();
}