using System;

namespace ComponentNetworkSimulation.Analysis
{
	/// <summary>
	/// This class extends EventArgs to provide a basic event argument structure for all log events.
	/// </summary>
	public class BasicLogEventArgs : EventArgs
	{
		#region data
		
		/// <summary>
		/// the log message of this log
		/// </summary>
		protected String message;
		
		#endregion

		#region constructors

		/// <summary>
		/// constructs a new instance of BasicLogEventArgs 
		/// </summary>
		/// <param name="message">the logmessage of this log</param>
		public BasicLogEventArgs(String message)
		{
			this.message = message;
		}

		#endregion

		#region properties

		/// <summary>
		/// return the message of this log
		/// </summary>
		public String Message
		{
			get { return this.message;}
		}

		#endregion
	}
}
//EOF