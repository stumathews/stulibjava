
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.ConversionException;
import javax.xml.bind.Dispatcher;
import javax.xml.bind.DuplicateAttributeException;
import javax.xml.bind.InvalidAttributeException;
import javax.xml.bind.InvalidContentObjectException;
import javax.xml.bind.LocalValidationException;
import javax.xml.bind.MarshallableObject;
import javax.xml.bind.MarshallableRootElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.MissingAttributeException;
import javax.xml.bind.MissingContentException;
import javax.xml.bind.NoValueException;
import javax.xml.bind.PredicatedLists;
import javax.xml.bind.PredicatedLists.Predicate;
import javax.xml.bind.RootElement;
import javax.xml.bind.StructureValidationException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidatableObject;
import javax.xml.bind.Validator;
import javax.xml.marshal.XMLScanner;
import javax.xml.marshal.XMLWriter;


public class Salesperson
    extends MarshallableRootElement
    implements RootElement
{

    private String _FullName;
    private double _Total;
    private boolean has_Total = false;
    private List _Sale = PredicatedLists.createInvalidating(this, new SalePredicate(), new ArrayList());
    private PredicatedLists.Predicate pred_Sale = new SalePredicate();

    public String getFullName() {
        return _FullName;
    }

    public void setFullName(String _FullName) {
        this._FullName = _FullName;
        if (_FullName == null) {
            invalidate();
        }
    }

    public double getTotal() {
        if (has_Total) {
            return _Total;
        }
        throw new NoValueException("Total");
    }

    public void setTotal(double _Total) {
        this._Total = _Total;
        has_Total = true;
        invalidate();
    }

    public boolean hasTotal() {
        return has_Total;
    }

    public void deleteTotal() {
        has_Total = false;
        invalidate();
    }

    public List getSale() {
        return _Sale;
    }

    public void deleteSale() {
        _Sale = null;
        invalidate();
    }

    public void emptySale() {
        _Sale = PredicatedLists.createInvalidating(this, pred_Sale, new ArrayList());
    }

    public void validateThis()
        throws LocalValidationException
    {
        if (_FullName == null) {
            throw new MissingAttributeException("fullName");
        }
        if (!has_Total) {
            throw new MissingContentException("Total");
        }
    }

    public void validate(Validator v)
        throws StructureValidationException
    {
        for (Iterator i = _Sale.iterator(); i.hasNext(); ) {
            v.validate(((ValidatableObject) i.next()));
        }
    }

    public void marshal(Marshaller m)
        throws IOException
    {
        XMLWriter w = m.writer();
        w.start("Salesperson");
        w.attribute("fullName", _FullName.toString());
        if (has_Total) {
            w.leaf("Total", Double.toString(_Total));
        }
        if (_Sale.size()> 0) {
            for (Iterator i = _Sale.iterator(); i.hasNext(); ) {
                m.marshal(((MarshallableObject) i.next()));
            }
        }
        w.end("Salesperson");
    }

    public void unmarshal(Unmarshaller u)
        throws UnmarshalException
    {
        XMLScanner xs = u.scanner();
        Validator v = u.validator();
        xs.takeStart("Salesperson");
        while (xs.atAttribute()) {
            String an = xs.takeAttributeName();
            if (an.equals("fullName")) {
                if (_FullName!= null) {
                    throw new DuplicateAttributeException(an);
                }
                _FullName = xs.takeAttributeValue();
                continue;
            }
            throw new InvalidAttributeException(an);
        }
        {
            xs.takeStart("Total");
            String s;
            if (xs.atChars(XMLScanner.WS_COLLAPSE)) {
                s = xs.takeChars(XMLScanner.WS_COLLAPSE);
            } else {
                s = "";
            }
            try {
                _Total = Double.parseDouble(s);
            } catch (Exception x) {
                throw new ConversionException("Total", x);
            }
            has_Total = true;
            xs.takeEnd("Total");
        }
        {
            List l = PredicatedLists.create(this, pred_Sale, new ArrayList());
            while (xs.atStart("Sale")) {
                l.add(((Sale) u.unmarshal()));
            }
            _Sale = PredicatedLists.createInvalidating(this, pred_Sale, l);
        }
        xs.takeEnd("Salesperson");
    }

    public static Salesperson unmarshal(InputStream in)
        throws UnmarshalException
    {
        return unmarshal(XMLScanner.open(in));
    }

    public static Salesperson unmarshal(XMLScanner xs)
        throws UnmarshalException
    {
        return unmarshal(xs, newDispatcher());
    }

    public static Salesperson unmarshal(XMLScanner xs, Dispatcher d)
        throws UnmarshalException
    {
        return ((Salesperson) d.unmarshal(xs, (Salesperson.class)));
    }

    public boolean equals(Object ob) {
        if (this == ob) {
            return true;
        }
        if (!(ob instanceof Salesperson)) {
            return false;
        }
        Salesperson tob = ((Salesperson) ob);
        if (_FullName!= null) {
            if (tob._FullName == null) {
                return false;
            }
            if (!_FullName.equals(tob._FullName)) {
                return false;
            }
        } else {
            if (tob._FullName!= null) {
                return false;
            }
        }
        if (has_Total) {
            if (!tob.has_Total) {
                return false;
            }
            if (_Total!= tob._Total) {
                return false;
            }
        } else {
            if (tob.has_Total) {
                return false;
            }
        }
        if (_Sale!= null) {
            if (tob._Sale == null) {
                return false;
            }
            if (!_Sale.equals(tob._Sale)) {
                return false;
            }
        } else {
            if (tob._Sale!= null) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int h = 0;
        h = ((127 *h)+((_FullName!= null)?_FullName.hashCode(): 0));
        h = ((31 *h)+((int)(Double.doubleToLongBits(_Total)^(Double.doubleToLongBits(_Total)>>> 32))));
        h = ((127 *h)+((_Sale!= null)?_Sale.hashCode(): 0));
        return h;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("<<Salesperson");
        if (_FullName!= null) {
            sb.append(" fullName=");
            sb.append(_FullName.toString());
        }
        if (has_Total) {
            sb.append(" Total=");
            sb.append(Double.toString(_Total));
        }
        if (_Sale!= null) {
            sb.append(" Sale=");
            sb.append(_Sale.toString());
        }
        sb.append(">>");
        return sb.toString();
    }

    public static Dispatcher newDispatcher() {
        return Sale.newDispatcher();
    }


    private static class SalePredicate
        implements PredicatedLists.Predicate
    {


        public void check(Object ob) {
            if (!(ob instanceof Sale)) {
                throw new InvalidContentObjectException(ob, (Sale.class));
            }
        }

    }

}
