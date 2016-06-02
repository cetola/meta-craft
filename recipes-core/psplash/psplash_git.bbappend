FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://psplash-colors.h \
"

do_configure_append () {
    cp ${WORKDIR}/psplash-colors.h ${S}
    touch ${S}/psplash.c
}
