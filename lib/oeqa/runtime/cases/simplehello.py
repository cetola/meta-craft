import os

from oeqa.runtime.case import OERuntimeTestCase
from oeqa.core.decorator.depends import OETestDepends
from oeqa.core.decorator.oeid import OETestID
from oeqa.core.decorator.data import skipIfNotFeature

class SimpleHelloTest(OERuntimeTestCase):

    @classmethod
    def setUpClass(cls):
        dst = '/tmp/'
        src = os.path.join('/path_to_my_file/', 'test.txt')
        #cls.tc.target.copyTo(src, dst)

    @classmethod
    def tearDownClass(cls):
        files = '/tmp/test.txt'
        #cls.tc.target.run('rm %s' % files)

    @OETestID(101)
    @skipIfNotFeature('x11-base',
                      'Test requires x11 to be in IMAGE_FEATURES')
    @OETestDepends(['ssh.SSHTest.test_ssh'])
    def test_hello(self):
        status, output = self.target.run('hello')
        msg = 'hello failed. sad. output: %s' % output
        self.tc.logger.info("test_simple_hello output: %s" % output)
        self.assertEqual(status, 0, msg=msg)

    @OETestID(221)
    def test_simple(self):
        status, output = self.target.run('simple')
        msg = 'simple failed. sad. output: %s' % output
        self.assertEqual(status, 0, msg=msg)
        self.assertEqual(output, "success", "wrong output: %s" % output)
