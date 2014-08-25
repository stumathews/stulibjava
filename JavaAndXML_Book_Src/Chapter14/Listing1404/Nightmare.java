
import java.io.IOException;
import java.io.InputStream;
import javax.xml.bind.Dispatcher;
import javax.xml.bind.DuplicateAttributeException;
import javax.xml.bind.InvalidAttributeException;
import javax.xml.bind.LocalValidationException;
import javax.xml.bind.MarshallableRootElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.MissingAttributeException;
import javax.xml.bind.RootElement;
import javax.xml.bind.StructureValidationException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Validator;
import javax.xml.marshal.XMLScanner;
import javax.xml.marshal.XMLWriter;


public class Nightmare
    extends MarshallableRootElement
    implements RootElement
{

    private String _Subject;
    private String _Severity;

    public String getSubject() {
        return _Subject;
    }

    public void setSubject(String _Subject) {
        this._Subject = _Subject;
        if (_Subject == null) {
            invalidate();
        }
    }

    public String getSeverity() {
        return _Severity;
    }

    public void setSeverity(String _Severity) {
        this._Severity = _Severity;
        if (_Severity == null) {
            invalidate();
        }
    }

    public void validateThis()
        throws LocalValidationException
    {
        if (_Subject == null) {
            throw new MissingAttributeException("subject");
        }
        if (_Severity == null) {
            throw new MissingAttributeException("severity");
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
        w.start("Nightmare");
        w.attribute("subject", _Subject.toString());
        w.attribute("severity", _Severity.toString());
        w.end("Nightmare");
    }

    public void unmarshal(Unmarshaller u)
        throws UnmarshalException
    {
        XMLScanner xs = u.scanner();
        Validator v = u.validator();
        xs.takeStart("Nightmare");
        while (xs.atAttribute()) {
            String an = xs.takeAttributeName();
            if (an.equals("subject")) {
                if (_Subject!= null) {
                    throw new DuplicateAttributeException(an);
                }
                _Subject = xs.takeAttributeValue();
                continue;
            }
            if (an.equals("severity")) {
                if (_Severity!= null) {
                    throw new DuplicateAttributeException(an);
                }
                _Severity = xs.takeAttributeValue();
                continue;
            }
            throw new InvalidAttributeException(an);
        }
        xs.takeEnd("Nightmare");
    }

    public static Nightmare unmarshal(InputStream in)
        throws UnmarshalException
    {
        return unmarshal(XMLScanner.open(in));
    }

    public static Nightmare unmarshal(XMLScanner xs)
        throws UnmarshalException
    {
        return unmarshal(xs, newDispatcher());
    }

    public static Nightmare unmarshal(XMLScanner xs, Dispatcher d)
        throws UnmarshalException
    {
        return ((Nightmare) d.unmarshal(xs, (Nightmare.class)));
    }

    public boolean equals(Object ob) {
        if (this == ob) {
            return true;
        }
        if (!(ob instanceof Nightmare)) {
            return false;
        }
        Nightmare tob = ((Nightmare) ob);
        if (_Subject!= null) {
            if (tob._Subject == null) {
                return false;
            }
            if (!_Subject.equals(tob._Subject)) {
                return false;
            }
        } else {
            if (tob._Subject!= null) {
                return false;
            }
        }
        if (_Severity!= null) {
            if (tob._Severity == null) {
                return false;
            }
            if (!_Severity.equals(tob._Severity)) {
                return false;
            }
        } else {
            if (tob._Severity!= null) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int h = 0;
        h = ((127 *h)+((_Subject!= null)?_Subject.hashCode(): 0));
        h = ((127 *h)+((_Severity!= null)?_Severity.hashCode(): 0));
        return h;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("<<Nightmare");
        if (_Subject!= null) {
            sb.append(" subject=");
            sb.append(_Subject.toString());
        }
        if (_Severity!= null) {
            sb.append(" severity=");
            sb.append(_Severity.toString());
        }
        sb.append(">>");
        return sb.toString();
    }

    public static Dispatcher newDispatcher() {
        Dispatcher d = new Dispatcher();
        d.register("Nightmare", (Nightmare.class));
        d.freezeElementNameMap();
        return d;
    }

}
