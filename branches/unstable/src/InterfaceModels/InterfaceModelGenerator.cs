//------------------------------------------------------------------------------
// <autogenerated>
//     This code was generated by CodeSmith.
//     Version: 2.5.14.0
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </autogenerated>
//------------------------------------------------------------------------------
using System;
using System.Collections;
using Palladio.Attributes;

namespace Palladio.ComponentModel.InterfaceModels
{
	#region DefaultInterfaceModel
	/// <summary>
	/// An IInterfaceModel is the description of an interface (of a component).
	/// In our case an interface is a set of signatures
	/// which can be somehow related to each other.
	/// </summary>
	internal class DefaultInterfaceModel : ICloneable, IAttributable, IInterfaceModel
	{
		protected ISignatureList signatureList;
		protected IAttributeHash attributes;
		protected ArrayList auxiliarySpecs = new ArrayList();
		
		public ISignatureList SignatureList
		{
			get
			{
				return signatureList;
			}
		}
		
		public IAttributeHash Attributes 
		{
			get 
			{
				return attributes;
			}
		}	
		
		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new DefaultInterfaceModel(this.attributes, this.signatureList);
		}
				
		public override bool Equals(object other)
		{
			if (!(other is IInterfaceModel)) return false;
			if (other == this) return true;
			IInterfaceModel model = (IInterfaceModel)other;
			return model.SignatureList.Equals(this.SignatureList);
		}
		
		public override int GetHashCode()
		{
			return (
				signatureList.GetHashCode()
			);		
		}

		/// <summary>
		/// Additional specification data like FSMs, Petri Nets, ....
		/// </summary>
		public IAuxiliaryInterfaceSpecification[] AuxiliarySpecifications
		{
			get
			{
				IAuxiliaryInterfaceSpecification[] result = new IAuxiliaryInterfaceSpecification[auxiliarySpecs.Count];
				auxiliarySpecs.CopyTo(result);
				return result;
			}
		}

		/// <summary>
		/// Get the auxiliary information of a given type
		/// </summary>
		/// <param name="aType">Type of the additional information to retrieve</param>
		/// <returns>The requested information or an exception if the information is not
		/// available</returns>
		public IAuxiliaryInterfaceSpecification GetAuxiliarySpecification(System.Type aType)
		{
			foreach (IAuxiliaryInterfaceSpecification spec in auxiliarySpecs)
			{
				if (aType.IsAssignableFrom(spec.GetType()))
					return spec;
			}
			throw new Exception("Auxiliary information not found!");
		}
		
		/// <summary>
		/// Add a new specification aspect to this interface, like a protocol spec.
		/// </summary>
		/// <param name="info">Additional specification data</param>
		public void AddAuxiliarySpecification(IAuxiliaryInterfaceSpecification info)
		{
			auxiliarySpecs.Add(info);
			signatureList.SignatureListChangeEvent += new SignatureListChangeEventHandler(info.SignatureListChangeEventHandler);
		}
			
		public DefaultInterfaceModel(IAttributeHash attrHash, ISignatureList aSignatureList)
		{
			this.signatureList = (ISignatureList)aSignatureList.Clone();
			this.attributes = attrHash;
		}
		
		public DefaultInterfaceModel(IAttributeHash attrHash)
		{
			signatureList = ComponentFactory.CreateSignatureList(new ISignature[0]);
			this.attributes = attrHash;
		}

		public void Serialize(System.Xml.XmlTextWriter writer) 
		{
			writer.WriteStartElement("SignatureList","http://palladio.informatik.uni-oldenburg.de/XSD");
			foreach (ISignature s in this.SignatureList) 
			{
				s.Serialize(writer);
			}
			writer.WriteEndElement();

			foreach (IAuxiliaryInterfaceSpecification a in this.AuxiliarySpecifications) 
			{
				writer.WriteStartElement("AuxiliarySpecification","http://palladio.informatik.uni-oldenburg.de/XSD");
				a.Serialize(writer);
				writer.WriteEndElement();
			}
		}

		public void Deserialize(System.Xml.XmlNode element) 
		{
			System.Xml.XmlNode childNode = element.FirstChild;

			while (childNode != null)
			{
				switch (childNode.Name) 
				{
					case "SignatureList":

						System.Xml.XmlNode signatureNode = childNode.FirstChild;
						while (signatureNode != null)
						{
							
							ISignature signature = ComponentFactory.CreateSignature("a");
							signature.Deserialize(signatureNode);
							this.signatureList.AddSignatures(signature);
							signatureNode = signatureNode.NextSibling;
						}						
						break;
					case "AuxiliarySpecification":
						break;
				}
				childNode = childNode.NextSibling;
			}
		}

	}
	#endregion
	
	#region DefaultServiceEffectSpecification
	/// <summary>
	/// An IInterfaceModel is the description of an interface (of a component).
	/// In our case an interface is a set of signatures
	/// which can be somehow related to each other.
	/// </summary>
	internal class DefaultServiceEffectSpecification : ICloneable, IAttributable, IServiceEffectSpecification
	{
		protected IExternalSignatureList signatureList;
		protected IAttributeHash attributes;
		protected ArrayList auxiliarySpecs = new ArrayList();
		
		public IExternalSignatureList SignatureList
		{
			get
			{
				return signatureList;
			}
		}
		
		public IAttributeHash Attributes 
		{
			get 
			{
				return attributes;
			}
		}	
		
		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new DefaultServiceEffectSpecification(this.attributes, this.signatureList);
		}
				
		public override bool Equals(object other)
		{
			if (!(other is IServiceEffectSpecification)) return false;
			if (other == this) return true;
			IServiceEffectSpecification model = (IServiceEffectSpecification)other;
			return model.SignatureList.Equals(this.SignatureList);
		}
		
		public override int GetHashCode()
		{
			return (
				signatureList.GetHashCode()
			);		
		}

		/// <summary>
		/// Additional specification data like FSMs, Petri Nets, ....
		/// </summary>
		public IAuxiliaryServiceEffectSpecification[] AuxiliarySpecifications
		{
			get
			{
				IAuxiliaryServiceEffectSpecification[] result = new IAuxiliaryServiceEffectSpecification[auxiliarySpecs.Count];
				auxiliarySpecs.CopyTo(result);
				return result;
			}
		}

		/// <summary>
		/// Get the auxiliary information of a given type
		/// </summary>
		/// <param name="aType">Type of the additional information to retrieve</param>
		/// <returns>The requested information or an exception if the information is not
		/// available</returns>
		public IAuxiliaryServiceEffectSpecification GetAuxiliarySpecification(System.Type aType)
		{
			foreach (IAuxiliaryServiceEffectSpecification spec in auxiliarySpecs)
			{
				if (aType.IsAssignableFrom(spec.GetType()))
					return spec;
			}
			throw new Exception("Auxiliary information not found!");
		}
		
		/// <summary>
		/// Add a new specification aspect to this interface, like a protocol spec.
		/// </summary>
		/// <param name="info">Additional specification data</param>
		public void AddAuxiliarySpecification(IAuxiliaryServiceEffectSpecification info)
		{
			auxiliarySpecs.Add(info);
			signatureList.SignatureListChangeEvent += new ExternalSignatureListChangeEventHandler(info.ExternalSignatureListChangeEventHandler);
		}
			
		public DefaultServiceEffectSpecification(IAttributeHash attrHash, IExternalSignatureList aSignatureList)
		{
			this.signatureList = (IExternalSignatureList)aSignatureList.Clone();
			this.attributes = attrHash;
		}
		
		public DefaultServiceEffectSpecification(IAttributeHash attrHash)
		{
			signatureList = ComponentFactory.CreateExternalSignatureList(new IExternalSignature[0]);
			this.attributes = attrHash;
		}
	}
	#endregion
}
