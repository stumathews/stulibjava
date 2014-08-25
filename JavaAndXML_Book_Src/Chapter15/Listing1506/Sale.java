
import java.io.IOException;
import java.io.InputStream;
import javax.xml.bind.ConversionException;
import javax.xml.bind.Dispatcher;
import javax.xml.bind.Element;
import javax.xml.bind.InvalidAttributeException;
import javax.xml.bind.LocalValidationException;
import javax.xml.bind.MarshallableObject;
import javax.xml.bind.Marshaller;
import javax.xml.bind.MissingContentException;
import javax.xml.bind.NoValueException;
import javax.xml.bind.StructureValidationException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Validator;
import javax.xml.marshal.XMLScanner;
import javax.xml.marshal.XMLWriter;


public class Sale
    extends MarshallableObject
    implements Element
{

    private String _ItemName;
    private double _UnitCost;
    private boolean has_UnitCost = false;
    private int _Quantity;
    private boolean has_Quantity = false;

    public String getItemName() {
        return _ItemName;
    }

    public void setItemName(String _ItemName) {
        this._ItemName = _ItemName;
        if (_ItemName == null) {
            invalidate();
        }
    }

    public double getUnitCost() {
        if (has_UnitCost) {
            return _UnitCost;
        }
        throw new NoValueException("UnitCost");
    }

    public void setUnitCost(double _UnitCost) {
        this._UnitCost = _UnitCost;
        has_UnitCost = true;
        invalidate();
    }

    public boolean hasUnitCost() {
        return has_UnitCost;
    }

    public void deleteUnitCost() {
        has_UnitCost = false;
        invalidate();
    }

    public int getQuantity() {
        if (has_Quantity) {
            return _Quantity;
        }
        throw new NoValueException("Quantity");
    }

    public void setQuantity(int _Quantity) {
        this._Quantity = _Quantity;
        has_Quantity = true;
        invalidate();
    }

    public boolean hasQuantity() {
        return has_Quantity;
    }

    public void deleteQuantity() {
        has_Quantity = false;
        invalidate();
    }

    public void validateThis()
        throws LocalValidationException
    {
        if (_ItemName == null) {
            throw new MissingContentException("ItemName");
        }
        if (!has_UnitCost) {
            throw new MissingContentException("UnitCost");
        }
        if (!has_Quantity) {
            throw new MissingContentException("Quantity");
        }
    }

    public void validate(Validator v)
        throws StructureValidationException
    {
    }

    public void marshal(Marshaller m)
        throws IOException
    {
        XMLWriter w = m.writer();
        w.start("Sale");
        w.leaf("ItemName", _ItemName.toString());
        if (has_UnitCost) {
            w.leaf("UnitCost", Double.toString(_UnitCost));
        }
        if (has_Quantity) {
            w.leaf("Quantity", Integer.toString(_Quantity));
        }
        w.end("Sale");
    }

    public void unmarshal(Unmarshaller u)
        throws UnmarshalException
    {
        XMLScanner xs = u.scanner();
        Validator v = u.validator();
        xs.takeStart("Sale");
        while (xs.atAttribute()) {
            String an = xs.takeAttributeName();
            throw new InvalidAttributeException(an);
        }
        if (xs.atStart("ItemName")) {
            xs.takeStart("ItemName");
            String s;
            if (xs.atChars(XMLScanner.WS_COLLAPSE)) {
                s = xs.takeChars(XMLScanner.WS_COLLAPSE);
            } else {
                s = "";
            }
            try {
                _ItemName = String.valueOf(s);
            } catch (Exception x) {
                throw new ConversionException("ItemName", x);
            }
            xs.takeEnd("ItemName");
        }
        {
            xs.takeStart("UnitCost");
            String s;
            if (xs.atChars(XMLScanner.WS_COLLAPSE)) {
                s = xs.takeChars(XMLScanner.WS_COLLAPSE);
            } else {
                s = "";
            }
            try {
                _UnitCost = Double.parseDouble(s);
            } catch (Exception x) {
                throw new ConversionException("UnitCost", x);
            }
            has_UnitCost = true;
            xs.takeEnd("UnitCost");
        }
        {
            xs.takeStart("Quantity");
            String s;
            if (xs.atChars(XMLScanner.WS_COLLAPSE)) {
                s = xs.takeChars(XMLScanner.WS_COLLAPSE);
            } else {
                s = "";
            }
            try {
                _Quantity = Integer.parseInt(s);
            } catch (Exception x) {
                throw new ConversionException("Quantity", x);
            }
            has_Quantity = true;
            xs.takeEnd("Quantity");
        }
        xs.takeEnd("Sale");
    }

    public static Sale unmarshal(InputStream in)
        throws UnmarshalException
    {
        return unmarshal(XMLScanner.open(in));
    }

    public static Sale unmarshal(XMLScanner xs)
        throws UnmarshalException
    {
        return unmarshal(xs, newDispatcher());
    }

    public static Sale unmarshal(XMLScanner xs, Dispatcher d)
        throws UnmarshalException
    {
        return ((Sale) d.unmarshal(xs, (Sale.class)));
    }

    public boolean equals(Object ob) {
        if (this == ob) {
            return true;
        }
        if (!(ob instanceof Sale)) {
            return false;
        }
        Sale tob = ((Sale) ob);
        if (_ItemName!= null) {
            if (tob._ItemName == null) {
                return false;
            }
            if (!_ItemName.equals(tob._ItemName)) {
                return false;
            }
        } else {
            if (tob._ItemName!= null) {
                return false;
            }
        }
        if (has_UnitCost) {
            if (!tob.has_UnitCost) {
                return false;
            }
            if (_UnitCost!= tob._UnitCost) {
                return false;
            }
        } else {
            if (tob.has_UnitCost) {
                return false;
            }
        }
        if (has_Quantity) {
            if (!tob.has_Quantity) {
                return false;
            }
            if (_Quantity!= tob._Quantity) {
                return false;
            }
        } else {
            if (tob.has_Quantity) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int h = 0;
        h = ((127 *h)+((_ItemName!= null)?_ItemName.hashCode(): 0));
        h = ((31 *h)+((int)(Double.doubleToLongBits(_UnitCost)^(Double.doubleToLongBits(_UnitCost)>>> 32))));
        h = ((31 *h)+ _Quantity);
        return h;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("<<Sale");
        if (_ItemName!= null) {
            sb.append(" ItemName=");
            sb.append(_ItemName.toString());
        }
        if (has_UnitCost) {
            sb.append(" UnitCost=");
            sb.append(Double.toString(_UnitCost));
        }
        if (has_Quantity) {
            sb.append(" Quantity=");
            sb.append(Integer.toString(_Quantity));
        }
        sb.append(">>");
        return sb.toString();
    }

    public static Dispatcher newDispatcher() {
        Dispatcher d = new Dispatcher();
        d.register("Sale", (Sale.class));
        d.register("Salesperson", (Salesperson.class));
        d.freezeElementNameMap();
        return d;
    }

}
