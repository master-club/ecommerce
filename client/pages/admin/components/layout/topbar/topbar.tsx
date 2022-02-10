import type { NextPage } from 'next';
import Image from 'next/image';
import Button from '../../ui/button/button';
import styles from './topbar.module.scss';

import Logo from '/public/images/logo.svg';

interface IProps {}

const Topbar: NextPage<IProps> = props => {
  return (
    <div className={styles.topbar}>
      <div className={styles.wrapper}>
        <div className={styles.stores}>
          <Button title="Master Store" icon={<Logo />} />
        </div>
        <div className={styles.search}></div>
        <div className={styles.user}>
          <Button
            title="Github Master"
            icon={<Image src="/images/github.png" width={32} height={32} alt="avatar" />}
          />
        </div>
      </div>
    </div>
  );
};

export default Topbar;
