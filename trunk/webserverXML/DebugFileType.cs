//
// DebugFileType.cs.cs
//
// This file was generated by XMLSPY 2004 Enterprise Edition.
//
// YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE
// OVERWRITTEN WHEN YOU RE-RUN CODE GENERATION.
//
// Refer to the XMLSPY Documentation for further details.
// http://www.altova.com/xmlspy
//


using System;
using System.Collections;
using System.Xml;
using Altova.Types;

namespace WebserverXML
{
	public class DebugFileType : Altova.Xml.Node
	{
		#region Forward constructors
		public DebugFileType() : base() { SetCollectionParents(); }
		public DebugFileType(XmlDocument doc) : base(doc) { SetCollectionParents(); }
		public DebugFileType(XmlNode node) : base(node) { SetCollectionParents(); }
		public DebugFileType(Altova.Xml.Node node) : base(node) { SetCollectionParents(); }
		#endregion // Forward constructors

		public override void AdjustPrefix()
		{

			for (int i = 0; i < DomChildCount(NodeType.Attribute, "", "path"); i++)
			{
				XmlNode DOMNode = GetDomChildAt(NodeType.Attribute, "", "path", i);
				InternalAdjustPrefix(DOMNode, false);
			}
		}


		#region path accessor methods
		public int GetpathMinCount()
		{
			return 1;
		}

		public int pathMinCount
		{
			get
			{
				return 1;
			}
		}

		public int GetpathMaxCount()
		{
			return 1;
		}

		public int pathMaxCount
		{
			get
			{
				return 1;
			}
		}

		public int GetpathCount()
		{
			return DomChildCount(NodeType.Attribute, "", "path");
		}

		public int pathCount
		{
			get
			{
				return DomChildCount(NodeType.Attribute, "", "path");
			}
		}

		public bool Haspath()
		{
			return HasDomChild(NodeType.Attribute, "", "path");
		}

		public SchemaString GetpathAt(int index)
		{
			return new SchemaString(GetDomNodeValue(GetDomChildAt(NodeType.Attribute, "", "path", index)));
		}

		public SchemaString Getpath()
		{
			return GetpathAt(0);
		}

		public SchemaString path
		{
			get
			{
				return GetpathAt(0);
			}
		}

		public void RemovepathAt(int index)
		{
			RemoveDomChildAt(NodeType.Attribute, "", "path", index);
		}

		public void Removepath()
		{
			while (Haspath())
				RemovepathAt(0);
		}

		public void Addpath(SchemaString newValue)
		{
			AppendDomChild(NodeType.Attribute, "", "path", newValue.ToString());
		}

		public void InsertpathAt(SchemaString newValue, int index)
		{
			InsertDomChildAt(NodeType.Attribute, "", "path", index, newValue.ToString());
		}

		public void ReplacepathAt(SchemaString newValue, int index)
		{
			ReplaceDomChildAt(NodeType.Attribute, "", "path", index, newValue.ToString());
		}
		#endregion // path accessor methods

		#region path collection
        public pathCollection	Mypaths = new pathCollection( );

        public class pathCollection: IEnumerable
        {
            DebugFileType parent;
            public DebugFileType Parent
			{
				set
				{
					parent = value;
				}
			}
			public pathEnumerator GetEnumerator() 
			{
				return new pathEnumerator(parent);
			}
		
			IEnumerator IEnumerable.GetEnumerator() 
			{
				return GetEnumerator();
			}
        }

        public class pathEnumerator: IEnumerator 
        {
			int nIndex;
			DebugFileType parent;
			public pathEnumerator(DebugFileType par) 
			{
				parent = par;
				nIndex = -1;
			}
			public void Reset() 
			{
				nIndex = -1;
			}
			public bool MoveNext() 
			{
				nIndex++;
				return(nIndex < parent.pathCount );
			}
			public SchemaString  Current 
			{
				get 
				{
					return(parent.GetpathAt(nIndex));
				}
			}
			object IEnumerator.Current 
			{
				get 
				{
					return(Current);
				}
			}
    	}

        #endregion // path collection

        private void SetCollectionParents()
        {
            Mypaths.Parent = this; 
	}
}
}
