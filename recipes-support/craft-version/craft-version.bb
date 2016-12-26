LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

PV = "${DISTRO_VERSION}"
PR = "r1"

SRC_URI="file://version.sh \
"

PACKAGES = "${PN}"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit update-rc.d

def get_layers(bb, d):
        layers = (d.getVar("BBLAYERS", d, 1) or "").split()
        layers_branch_rev = ["%-17s = \"%s:%s\"" % (os.path.basename(i), \
                base_get_metadata_git_branch(i, None).strip().strip('()'), \
                base_get_metadata_git_revision(i, None)) \
                        for i in layers]
        i = len(layers_branch_rev)-1
        p1 = layers_branch_rev[i].find("=")
        s1= layers_branch_rev[i][p1:]
        while i > 0:
                p2 = layers_branch_rev[i-1].find("=")
                s2= layers_branch_rev[i-1][p2:]
                if s1 == s2:
                        layers_branch_rev[i-1] = layers_branch_rev[i-1][0:p2]
                        i -= 1
                else:
                        i -= 1
                        p1 = layers_branch_rev[i].find("=")
                        s1= layers_branch_rev[i][p1:]

        layertext = "%s\n" % '\n'.join(layers_branch_rev)
        layertext = layertext.replace('<','')
        layertext = layertext.replace('>','')
        return layertext

do_install() {
	install -d ${D}${sysconfdir}
	echo "${DISTRO} ${DISTRO_VERSION}"  > ${D}${sysconfdir}/craft-version
	echo "BB_VERSION        = ${BB_VERSION}" >> ${D}${sysconfdir}/craft-version
	echo "TARGET_ARCH       = ${TARGET_ARCH}" >> ${D}${sysconfdir}/craft-version
	echo "TARGET_OS         = ${TARGET_OS}" >> ${D}${sysconfdir}/craft-version
	echo "MACHINE           = ${MACHINE}" >> ${D}${sysconfdir}/craft-version
	echo "TUNE_FEATURES     = ${TUNE_FEATURES}" >> ${D}${sysconfdir}/craft-version
	echo "TARGET_FPU        = ${TARGET_FPU}" >> ${D}${sysconfdir}/craft-version
	echo "${@get_layers(bb, d)}" >> ${D}${sysconfdir}/craft-version

   	install -d ${D}${sysconfdir}/init.d/
        install -m 0755 ${WORKDIR}/version.sh ${D}${sysconfdir}/init.d/version.sh
 
}

INITSCRIPT_NAME = "version.sh"
INITSCRIPT_PARAMS = "start 1 S ."
