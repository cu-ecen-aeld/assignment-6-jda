# See https://git.yoctoproject.org/poky/tree/meta/files/common-licenses
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://git@github.com/cu-ecen-aeld/assignments-3-and-later-jda;protocol=ssh;branch=main"

PV = "1.0+git${SRCPV}"
SRCREV = "25f48ed118733c1806a97a91bb0571377405040a"

# This sets your staging directory based on WORKDIR, where WORKDIR is defined at 
# https://docs.yoctoproject.org/ref-manual/variables.html?highlight=workdir#term-WORKDIR
# We reference the "server" directory here to build from the "server" directory
# in your assignments repo
S = "${WORKDIR}/git/server"

RDEPENDS:${PN} += "libgcc"
FILES:${PN} += "${bindir}/aesdsocket ${bindir}/aesdsocket-start-stop"
TARGET_LDFLAGS += "-lrt"

do_configure () {
	:
}

do_compile () {
	oe_runmake
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${S}/aesdsocket ${D}${bindir}/

	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${S}/aesdsocket-start-stop ${D}${sysconfdir}/init.d/

    install -d ${D}${sysconfdir}/rcS.d
    install -d ${D}${sysconfdir}/rc1.d
    install -d ${D}${sysconfdir}/rc2.d
    install -d ${D}${sysconfdir}/rc3.d
    install -d ${D}${sysconfdir}/rc4.d
    install -d ${D}${sysconfdir}/rc5.d

	ln -sf ../init.d/aesdsocket-start-stop      ${D}${sysconfdir}/rc1.d/K90aesdsocket
    ln -sf ../init.d/aesdsocket-start-stop      ${D}${sysconfdir}/rc2.d/K90aesdsocket
    ln -sf ../init.d/aesdsocket-start-stop      ${D}${sysconfdir}/rc3.d/K90aesdsocket
    ln -sf ../init.d/aesdsocket-start-stop      ${D}${sysconfdir}/rc4.d/K90aesdsocket
    ln -sf ../init.d/aesdsocket-start-stop      ${D}${sysconfdir}/rc5.d/S90aesdsocket  	
}
