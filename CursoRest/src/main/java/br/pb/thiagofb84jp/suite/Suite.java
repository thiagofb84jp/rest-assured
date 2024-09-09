package br.pb.thiagofb84jp.suite;

import br.pb.thiagofb84jp.test.BuscarStatusApiTest;
import br.pb.thiagofb84jp.test.ProdutoTest;
import br.pb.thiagofb84jp.test.UsuarioTest;
import org.junit.runner.RunWith;

@RunWith(org.junit.runners.Suite.class)
@org.junit.runners.Suite.SuiteClasses({
        BuscarStatusApiTest.class,
        UsuarioTest.class,
        ProdutoTest.class
})
public class Suite {
}
