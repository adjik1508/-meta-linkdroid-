SSUMMARY = "Amlogic audio video utils library"
PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(alien5|k1pro|k2pro|k2prov2|k3pro|k1plus|kvim2|c300|c300pro|c400plus|alien4)$"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCDATE = "20180516"

PV = "${SRCDATE}"

inherit lib_package

SRC_URI[md5sum] = "a1809717024cc0095e7f42ad658b71d2"
SRC_URI[sha256sum] = "0c66f77ea32ee0cffb610a916aac85dd80cf0f1799a03987ae4308f5a6f55f28"

SRC_URI = "http://source.mynonpublic.com/linkdroid/${BPN}-${SRCDATE}.zip"


S = "${WORKDIR}"

do_install() {
    install -d ${D}${libdir}
    install -m 0755 ${WORKDIR}/libaac_helix.so ${D}${libdir}/
    install -m 0755 ${WORKDIR}/libadpcm.so ${D}${libdir}/
    install -m 0755 ${WORKDIR}/libamr.so ${D}${libdir}/
    install -m 0755 ${WORKDIR}/libape.so ${D}${libdir}/
    install -m 0755 ${WORKDIR}/libcook.so ${D}${libdir}/
    install -m 0755 ${WORKDIR}/libfaad_aml.so ${D}${libdir}/
    install -m 0755 ${WORKDIR}/libflac.so ${D}${libdir}/
    install -m 0755 ${WORKDIR}/libpcm_wfd.so ${D}${libdir}/
    install -m 0755 ${WORKDIR}/libmad_aml.so ${D}${libdir}/
    install -m 0755 ${WORKDIR}/libpcm.so ${D}${libdir}/
    install -m 0755 ${WORKDIR}/libraac.so ${D}${libdir}/
    install -m 0755 ${WORKDIR}/libac3.so ${D}${libdir}/
    install -m 0755 ${WORKDIR}/libdts.so ${D}${libdir}/
    install -m 0755 ${WORKDIR}/libdtshd.so ${D}${libdir}/
}

FILES_${PN} += "${libdir}/*"
FILES_${PN}-dev = ""

do_configure() {
}

do_compile() {
}

do_package_qa() {
}

