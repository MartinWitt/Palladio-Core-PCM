using System;
using System.Collections;
using System.Net.Sockets;

namespace Palladio.Webserver.Request
{
	/// <summary>
	/// IHTTPRequest.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.5  2004/11/05 16:17:01  kelsaka
	/// Added support for simple dynamic content (SimpleTemplateFileProvider). For this added a new xml-config-file and auto-generated XML-classes.
	/// Code refactoring.
	///
	/// Revision 1.4  2004/10/31 16:30:40  kelsaka
	/// preparing parsing of post-requests
	///
	/// Revision 1.3  2004/10/29 16:30:39  kelsaka
	/// a lot of changes: xml-schema changed: added default mimetype; delivering file with the static file provider; changed parsing of filename; added parsing of variables; Altova-xml-spy-classes updated, ...
	///
	/// </pre>
	/// </remarks>
	public interface IHTTPRequest
	{ 


		/// <summary>
		/// The version of the http-request.
		/// </summary>
		string HttpVersion {get; set;}

		/// <summary>
		/// The name of the file that is requested by the client (including the suffix: e. g. "index.html").
		/// </summary>
		string RequestedFileName {get; set;}


		/// <summary>
		/// The file-suffix like ".html" of the requested file.
		/// </summary>
		string RequestedFileType {get; set;}


		/// <summary>
		/// The name of the directory that is requested by the client.
		/// </summary>
		string RequestedDirectoyName {get; set;}
		

		/// <summary>
		/// Represents the http method-type: e. g. get and post.
		/// </summary>
		int RequestedMethodType { get; set; }


		/// <summary>
		/// The Socket of the request.
		/// </summary>
		Socket Socket {get; set;}


		/// <summary>
		/// Creates a new key / value-pair if the key is new, otherwise updates the value for the key.
		/// Intention: use for the variables values of the http-request.
		/// </summary>
		/// <param name="key">The key.</param>
		/// <param name="value">Value for the given key.</param>
		void SetGETVariableValue(string key, string value);

		/// <summary>
		/// Creates a new key / value-pair if the key is new, otherwise updates the value for the key.
		/// Intention: use for the POST-variables values of the http-request.
		/// </summary>
		/// <param name="key">The key. Attention: duplicate keys are overwriten.</param>
		/// <param name="value">Value for the given key.</param>
		void SetPOSTVariableValue (string key, string value);

		/// <summary>
		/// Returns the value for the given key. Use for the http-request variables values. GET-Method.
		/// </summary>
		/// <param name="key">The key to return the value for.</param>
		/// <returns>The Value for the key.</returns>
		string GetGETVariableValue(string key);


		/// <summary>
		/// Returns the value for the given key. Use for the http-request variables values. POST-Method.
		/// </summary>
		/// <param name="key">The key to return the value for.</param>
		/// <returns>The Value for the key.</returns>
		string GetPOSTVariableValue(string key);


		/// <summary>
		/// Returns the internal Hashtable that contains the key-value-pairs for the variables of a GET-Request.
		/// </summary>
		Hashtable POSTHashtable {get;}


		/// <summary>
		/// Returns the internal Hashtable that contains the key-value-pairs for the variables of a POST-Request.
		/// </summary>
		Hashtable GETHashtable {get;}


	}
}
