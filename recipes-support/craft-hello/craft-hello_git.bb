# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=040a88eddd5ecff455a65fefa0136a06"

SRC_URI = "git://github.com/cetola/hello_dev.git;protocol=http" 


# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "dbeb1448cf67f6e78fa35ad25a9beeaff8fb0eb6"

S = "${WORKDIR}/git"
DEPENDS = "curl"
RDEPENDS_${PN} = "curl"
INSANE_SKIP_${PN} = "ldflags"


# NOTE: this is a Makefile-only piece of software, so we cannot generate much of the
# recipe automatically - you will need to examine the Makefile yourself and ensure
# that the appropriate arguments are passed in.

do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# You will almost certainly need to add additional arguments here
	oe_runmake
}

do_install () {
	# NOTE: unable to determine what to put here - there is a Makefile but no
	# target named "install", so you will need to define this yourself
    install -d ${D}/usr
    install -d ${D}/usr/bin

    install -m 0755 ${S}/hello ${D}/usr/bin
    install -m 0755 ${S}/simple ${D}/usr/bin
}
