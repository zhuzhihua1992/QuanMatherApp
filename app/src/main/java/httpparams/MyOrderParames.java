package httpparams;

import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;

import config.ServiceInterface;

/**
 * Created by Administrator on 2016/12/28.
 */
@HttpRequest(host = ServiceInterface.BASEURL,path = ServiceInterface.MYORDER)
public class MyOrderParames extends RequestParams{
    public MyOrderParames(){
        addBodyParameter("usertoken","3BAE791A2A61FA2176D5CF1BFF6D5BB39B43C794F25B3529185BC971A97FD246B1D29C636D9C380908FE0224D3D9D48621072C3004D0FBE0F22396837F477A420654CD3F558D9777E78E15B16BF8B3D338B432F78FDC3BF2F40C8834696340B97095B125CCA1166FDA3F56F9A0637ED49ECDBF89329956DB33A7479A718F3F29031E7429CB1E9D5E8EE8CAED3588301DBA9C58694395686BA50617074A4199F5F65EFA221F0E322A3C29C64559981CE3DBB4B9CBA1E311D010290FEFC371B191");
    }

}
